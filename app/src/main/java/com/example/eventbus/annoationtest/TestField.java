package com.example.eventbus.annoationtest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


//java中元注解有四个： @Retention @Target @Document @Inherited；
//　一 @Retention：注解的保留位置　　　　　　　　　
//
// @Retention(RetentionPolicy.SOURCE) //注解仅存在于源码中，在class字节码文件中不包含
//　@Retention(RetentionPolicy.CLASS) // 默认的保留策略，注解会在class字节码文件中存在，但运行时无法获得，
//　@Retention(RetentionPolicy.RUNTIME) // 注解会在class字节码文件中存在，在运行时可以通过反射获取到
//二 @Target:注解的作用目标
//　@Target(ElementType.TYPE) //接口、类、枚举、注解
//　@Target(ElementType.FIELD) //字段、枚举的常量
//　@Target(ElementType.METHOD) //方法
//　@Target(ElementType.PARAMETER) //方法参数
//　@Target(ElementType.CONSTRUCTOR) //构造函数
//　@Target(ElementType.LOCAL_VARIABLE)//局部变量
//　@Target(ElementType.ANNOTATION_TYPE)//注解
//　@Target(ElementType.PACKAGE) ///包
// 三 @Document：说明该注解将被包含在javadoc中
//四 @Inherited：说明子类可以继承父类中的该注解

@Target({ElementType.FIELD})//@Target说明了Annotation所修饰的对象范围


@Retention(RetentionPolicy.RUNTIME)//注解@Retention可以用来修饰注解，是注解的注解，称为元注解。
//1、RetentionPolicy.SOURCE：注解只保留在源文件，当Java文件编译成class文件的时候，注解被遗弃；
// 2、RetentionPolicy.CLASS：注解被保留到class文件，但jvm加载class文件时候被遗弃，这是默认的生命周期；
// 3、RetentionPolicy.RUNTIME：注解不仅被保存到class文件中，jvm加载class文件之后，仍然存在；
public @interface TestField {
    int max() default 0;

    int min() default 0;

    String description() default "";

}
