package com.hql.proxyhelper.proxy;

import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author ly-huangql
 * <br /> Create time : 2022/4/14
 * <br /> Description :为什么要使用代理模式
 * 可以间接访问对象，防止直接访问对象来的不必要复杂性
 * 通过代理对象对访问进行控制
 * 并且中间做一些增强操作
 *
 */
public class DynamicProxy implements InvocationHandler {
    private static final String TAG = "DynamicProxy_hql";
    //	 为了重复使用，所以我们无法写某一个对象类
    private Object objectClass;

    public Object getObject() {
        return this.objectClass;
    }

    public void bindObject(Object objectClass) {
        this.objectClass = objectClass;
    }

    public Object getProxyInstance() {
        //
        //objectClass.getClass().getClassLoader() 前面说反射的的四种方式，这个就是通过第四种，通过加载器进行反射创建类的。 如果深究的话那就需要看Proxy这个类的源码了。
        return Proxy.newProxyInstance(objectClass.getClass().getClassLoader(), objectClass.getClass().getInterfaces(), this);
    }

    //InvocationHandler 这个接口下的方法 自动会将我们调用的方法放入Method method,以及参数Object[] args。而proxy代表的是我们创建的一个匿名代理类
// 这个是这个接口源码定义的，所以不要纠结为什么，主要是理解这个设计思路。而方法文档截图放下面可以看一下。
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 进行业务增强
        if (objectClass instanceof KoreaOrderService) {

            Object invoke = method.invoke(objectClass, args);
            invoke = (Integer) invoke + 300;
            Log.d(TAG, "购买韩国相机  中间商赚差价300");
            return invoke;
        } else if (objectClass instanceof JapanOrderService) {
            Object invoke = method.invoke(objectClass, args);
            invoke = (Integer) invoke + 600;
            Log.d(TAG, "购买日本相机  中间商赚差价600");
            return invoke;
        }
        return -1;
    }




}
