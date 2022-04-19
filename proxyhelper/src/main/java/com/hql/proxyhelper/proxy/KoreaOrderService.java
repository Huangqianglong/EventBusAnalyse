package com.hql.proxyhelper.proxy;

import android.util.Log;

/**
 * @author ly-huangql
 * <br /> Create time : 2022/4/14
 * <br /> Description : 韩国代购
 */
public class KoreaOrderService implements OrderService {
    private final String TAG = "KoreaOrderService_hql";

    @Override
    public int buyCamera() {
        Log.d(TAG,"韩国代购买相机");
        return 10000;
    }

}
