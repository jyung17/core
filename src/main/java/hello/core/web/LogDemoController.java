package hello.core.web;

import hello.core.common.MyLogger;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class LogDemoController {
  
  private final logDemoService logDemoService;
  private final MyLogger myLogger;
  
  @RequestMapping("log-demo")
  @ResponseBody
  public String logDemo(HttpServletRequest request) throws InterruptedException {
    String requestURL = request.getRequestURI().toString();
  
    System.out.println("myLogger = " + myLogger.getClass());
    myLogger.setRequestURL(requestURL);
    
    myLogger.log("controller test");
    Thread.sleep(1000);
    logDemoService.logic("testId");
    return "OK";
  }
}
