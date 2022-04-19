package com.hql.proxyhelper.proxy;

import android.util.Log;

/**
 * @author ly-huangql
 * <br /> Create time : 2022/4/14
 * <br /> Description : 日本代购
 */
public class JapanOrderService implements OrderService {
    private final String TAG = "JapanOrderService_hql";

    @Override
    public int buyCamera() {
        Log.d(TAG,"日本代购买相机");
        return 5000;
    }

}
