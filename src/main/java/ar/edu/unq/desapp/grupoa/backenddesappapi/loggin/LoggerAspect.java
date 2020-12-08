package ar.edu.unq.desapp.grupoa.backenddesappapi.loggin;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {

    Logger log = LoggerFactory.getLogger(LoggerAspect.class);

    @Pointcut(value="execution(* ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.*.*.*(..) )")
    public void myPointcut() {

    }

    @Around("myPointcut()")
    public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
        ObjectMapper mapper = new ObjectMapper();
        String methodName = pjp.getSignature().getName();
        String className = pjp.getTarget().getClass().toString();
        Object[] array = pjp.getArgs();
        Object object = pjp.proceed();
        log.info("method invoked " +className + " : "
                + methodName + "()" +
                "arguments : " + mapper.writeValueAsString(array) +
                "Response : "  + mapper.writeValueAsString(object));
        return object;
    }
}
