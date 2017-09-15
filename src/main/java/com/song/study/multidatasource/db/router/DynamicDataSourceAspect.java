package com.song.study.multidatasource.db.router;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(-1)
@Component
public class DynamicDataSourceAspect {

    @Around("@annotation(targetDataSource)")
    public Object targetDataSource(ProceedingJoinPoint pjp, TargetDataSource targetDataSource) throws Throwable {
        DataSourceType dataSourceType = targetDataSource.type();

        if (DynamicDataSource.containsDataSource(dataSourceType)) {
            DynamicDataSource.setDataSourceType(targetDataSource.type());
        }
        try {
            return pjp.proceed();
        } finally {
            DynamicDataSource.reset();
        }
    }
}
