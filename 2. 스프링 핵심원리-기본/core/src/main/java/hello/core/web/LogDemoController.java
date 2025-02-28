package hello.core.web;

import hello.core.common.MyLogger;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
    private final MyLogger myLogger;

    @RequestMapping("log-demo")
    @ResponseBody                       // 뷰화면 없이 문자를 바로 반환하고 싶음
    public String logDemo(HttpServletRequest request) throws InterruptedException { // 규약: 고객 요청정보를 받을 수 있다
        String requestURL = request.getRequestURL().toString();

        System.out.println("myLogger = " + myLogger.getClass());
        myLogger.setRequestURL(requestURL);
        myLogger.log("controller test");

        Thread.sleep(1000);
        logDemoService.logic("service -> " + "testId");

        return "OK";
    }
}
