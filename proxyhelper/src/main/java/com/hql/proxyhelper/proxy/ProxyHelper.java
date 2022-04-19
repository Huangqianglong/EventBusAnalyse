package com.hql.proxyhelper.proxy;

import android.util.Log;

/**
 * @author ly-huangql
 * <br /> Create time : 2022/4/15
 * <br /> Description :
 */
public class ProxyHelper {
    private static String TAG = "ProxyHelper_hql";
    public static class ProxyHelperHolder {
        private static ProxyHelper mInstance = new ProxyHelper();
    }

    public static ProxyHelper getInstance(){
        return ProxyHelperHolder.mInstance;
    }
    private DynamicProxy mDynamicProxy;
    private KoreaOrderService mKoreaOrderService;
    private JapanOrderService mJapanOrderService;
    private ProxyHelper() {
        mDynamicProxy = new DynamicProxy();
        mKoreaOrderService = new KoreaOrderService();
        mJapanOrderService = new JapanOrderService();
    }

    public int buyJapanCamera() {
        mDynamicProxy.bindObject(mJapanOrderService);
        OrderService orderService = (OrderService) mDynamicProxy.getProxyInstance();
        Log.d(TAG,"buyJapanCamera");
        return orderService.buyCamera();
    }
    public int buyKoreaCamera(){
        mDynamicProxy.bindObject(mKoreaOrderService);
        OrderService orderService = (OrderService) mDynamicProxy.getProxyInstance();
        Log.d(TAG,"buyKoreaCamera");
        return orderService.buyCamera();
    }

}
