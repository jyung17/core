package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;


// AppConfig는 애플리케이션의 실제 동작에 필요한 구현 객체를 생성한다.
// AppConfig는 생성한 객체 인스턴스의 참조(레퍼런스)를 생성자를 통해서 주입(연결)해준다.
public class AppConfig {
  
  // appConfig 객체는 memoryMemberRepository 객체를 생성하고
  // 그 참조값을 memberServiceImpl 을 생성하면서 생성자로 전달한다.
  // 클라이언트인 memberServiceImpl 입장에서 보면 의존관계를 마치 외부에서 주입해주는 것 같다고 해서
  // DI(Dependency Injection) 우리말로 의존관계 주입 또는 의존성 주입이라 한다.
  public MemberService memberService() {
    return new MemberServiceImpl(memberRepository());
  }
  
  private static MemoryMemberRepository memberRepository() {
    return new MemoryMemberRepository();
  }
  
  public OrderService orderService() {
    return new OrderServiceImpl(memberRepository(), discountPolicy());
  }
  
  public DiscountPolicy discountPolicy() {
//    return new FixDiscountPolicy();
    return new RateDiscountPolicy();
  }
}
