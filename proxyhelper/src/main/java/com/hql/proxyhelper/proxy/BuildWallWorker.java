package com.hql.proxyhelper.proxy;

import android.util.Log;

/**
 * @author ly-huangql
 * <br /> Create time : 2022/4/14
 * <br /> Description : 砌墙工人
 */
public class BuildWallWorker implements BuildWall {
    private final String TAG = "BuildWallWorker_hql";
    @Override
    public void buildWall() {
        Log.d(TAG,"砌墙工人开始砌墙了");
    }
    private void buyBrick(){
        Log.d(TAG,"砌墙要先买砖");
    }
}
