package com.roncoo.adminlte.util.base;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.stereotype.Component;

/**
 * 标识MyBatis，方便 {@link org.mybatis.spring.mapper.MapperScannerConfigurer}的扫描
 * 
 * @author hugovon
 * @version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Component
public @interface MyBatis {
}
