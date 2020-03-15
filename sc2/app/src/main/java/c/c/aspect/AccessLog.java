package c.c.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.Date;

/**
 * Created by admin
 */
@Aspect
@Component
public class AccessLog {

    @Autowired
    private Environment environment;

    @Pointcut(value= "execution(* c.c.controller..*(..))")
    private void logPointcut()
    {
    }

    @Around(value = "logPointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint){
        System.out.println(new Date());
        System.out.println("local port "+environment.getProperty("server.port"));
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

        //Get intercepted method details
        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();

        final StopWatch stopWatch = new StopWatch();

        System.out.println("before "+className+"."+methodName);

        //Measure method execution time
        stopWatch.start();
        Object result = null;
        try {

            result = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        stopWatch.stop();

        System.out.println("after "+className+"."+methodName);

        return result;
    }




}
