package by.trofimov.spring.mvc_hibernate_aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import static by.trofimov.spring.mvc_hibernate_aop.util.Constant.*;

@Component
@Aspect
public class MyLoggingAspect {

    @Around("execution(* by.trofimov.spring.mvc_hibernate_aop.dao.*.*(..))")
    public Object aroundAllRepositoryMethodsAdvice(
            ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String methodName = methodSignature.getName();
        System.out.println(BEGIN_OF + methodName);
        Object targetMethodResult = proceedingJoinPoint.proceed();
        System.out.println(END_OF + methodName);
        return targetMethodResult;
    }

}
