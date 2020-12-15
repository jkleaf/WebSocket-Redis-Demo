package tk.leaflame.websocketdemo.advice.log;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author leaflame
 * @date 2020/4/16 12:36
 */
@Component
@Aspect
@Slf4j
public class LogHandler {

    @Pointcut("execution(public * tk.leaflame.websocketdemo.controller.*.*(..))")
    public void loggingController(){
        log.info("logging Controller...");
    }

    @Before("loggingController()")
    public void beforeLoggingController(JoinPoint joinPoint){
//        joinPoint.getArgs();
//        joinPoint.getSignature();
        log.info("before logging Controller...");
    }

    @After("loggingController()")
    public void afterLoggingController(){
        log.info("after logging Controller...");
    }
}
