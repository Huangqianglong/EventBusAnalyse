package com.hql.proxyhelper.proxy;

/**
 * @author ly-huangql
 * <br /> Create time : 2022/4/15
 * <br /> Description :
 */
public class ProxyHelper {
    public static class ProxyHelperHolder {
        private static ProxyHelper mInstance = new ProxyHelper();
    }

    public static ProxyHelper getInstance(){
        return ProxyHelperHolder.mInstance;
    }
    private DynamicProxy mDynamicProxy;
    private BuildWall mBuildWall;
    private Excavate mExcavate;

    private ProxyHelper() {
        mDynamicProxy = new DynamicProxy();
        mBuildWall = new BuildWallWorker();
        mExcavate = new ExcavateWorker();
    }

    public void BuildWall() {
        mDynamicProxy.bindObject(mBuildWall);
        BuildWall buildWallInstance = (BuildWall) mDynamicProxy.getProxyInstance();
        buildWallInstance.buildWall();
    }
    public void Excavate(){
        mDynamicProxy.bindObject(mExcavate);
        Excavate ExcavateInstance = (Excavate) mDynamicProxy.getProxyInstance();
        ExcavateInstance.excavate();
    }

}
