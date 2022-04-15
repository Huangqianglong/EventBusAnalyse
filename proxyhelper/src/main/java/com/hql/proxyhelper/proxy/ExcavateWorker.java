package com.hql.proxyhelper.proxy;

import android.util.Log;

/**
 * @author ly-huangql
 * <br /> Create time : 2022/4/14
 * <br /> Description : 挖坑工人
 */
public class ExcavateWorker implements Excavate {
    private final String TAG = "ExcavateWorker_hql";

    @Override
    public void excavate() {
        Log.d(TAG,"挖坑工人开始挖坑了");
    }
    private void buyShovel(){
        Log.d(TAG,"挖坑要先买铲子");
    }
}
