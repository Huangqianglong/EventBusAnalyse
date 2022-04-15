package com.example.eventbus.annoationtest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author ly-huangql
 * <br /> Create time : 2022/4/14
 * <br /> Description :
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface BindClick {
    int id() default 0;
}
