package com.projects.projects.aspects;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SoftDeleteAspect {

    @Pointcut("execution(public boolean com.productos_de_sw.productos_de_sw.services.*.softDelete(Long)) && args(id)")
    public void softDeletePointcut(Long id) {
    }

    @AfterReturning(pointcut = "softDeletePointcut(id)", returning = "result", argNames = "id,result")
    public void logAfterReturningSoftDelete(Long id, boolean result) {
        System.out.println("After softDelete method with id: " + id + ", result: " + result);
    }
}
