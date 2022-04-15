package com.hql.proxyhelper.proxy;

import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author ly-huangql
 * <br /> Create time : 2022/4/14
 * <br /> Description :我们是工程监理。正常情况是老板直接派工作给工人，用了代理模式之后，就相当于多了一个包工头，这个包工头是我们工程监理强行派过去的，这回老板会把工作派给包工头，包工头就是代理对象，包工头再把工作派给工人。因为包工头是咱自己派的人，所以我们就能监视老板派给工人的一切工作和内容，我们再让这个包工头动一些手脚。这就实现了hook技术
 */
public class DynamicProxy implements InvocationHandler {
    private static final String TAG = "DynamicProxy_hql";
    //	 为了重复使用，所以我们无法写某一个对象类
    private Object objectClass;
    public Object getObject() {
        return this.objectClass;
    }

    public void bindObject(Object objectClass) {
        this.objectClass= objectClass;
    }
    public  Object getProxyInstance() {
        //
        //objectClass.getClass().getClassLoader() 前面说反射的的四种方式，这个就是通过第四种，通过加载器进行反射创建类的。 如果深究的话那就需要看Proxy这个类的源码了。
        return Proxy.newProxyInstance(objectClass.getClass().getClassLoader(), objectClass.getClass().getInterfaces(), this);
    }
    //InvocationHandler 这个接口下的方法 自动会将我们调用的方法放入Method method,以及参数Object[] args。而proxy代表的是我们创建的一个匿名代理类
// 这个是这个接口源码定义的，所以不要纠结为什么，主要是理解这个设计思路。而方法文档截图放下面可以看一下。
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 进行业务增强
        System.out.println("动态代理前");
        checkToolReady(proxy);
        // 通过反射调用方法本身
        Object invoke = method.invoke(objectClass, args);
        System.out.println("动态代理后");
        return invoke;
    }
    private void checkToolReady(Object proxy){
        //Log.d(TAG,"checkToolReady  proxy:"+proxy.toString());
        if(proxy instanceof BuildWall){
            Log.d(TAG,"BuildWall  checkToolReady");
        }else if (proxy instanceof Excavate){
            Log.d(TAG,"Excavate checkToolReady");
        }
    }


}
