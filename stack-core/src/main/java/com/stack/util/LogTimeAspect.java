package com.stack.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component  // For Spring AOP
@Aspect
public class LogTimeAspect {
	
	protected final Log logger = LogFactory.getLog(getClass());

    @Around(value = "@annotation(annotation)")
    public Object LogExecutionTime(final ProceedingJoinPoint joinPoint, final LogExecTime annotation) throws Throwable {
        final long startMillis = System.currentTimeMillis();
		
	        try {
	        	String ar = "";
	        	Object[] args = joinPoint.getArgs();
	        	for (Object object : args) {
					ar+=String.format(" \"%s\" ", object);
				}
	        	logger.info("# AspectJ example #: Calling "+joinPoint.getSignature() + "with"+ar);
	        } finally {
	            final long duration = System.currentTimeMillis() - startMillis;
	            logger.info(" took " + duration + " ms");
	        }
		
		return joinPoint.proceed();
    }
}
