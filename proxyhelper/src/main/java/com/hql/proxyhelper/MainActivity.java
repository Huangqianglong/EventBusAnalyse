package com.hql.proxyhelper;

import android.app.Activity;
import android.os.Bundle;

import com.hql.proxyhelper.proxy.BuildWall;
import com.hql.proxyhelper.proxy.BuildWallWorker;
import com.hql.proxyhelper.proxy.DynamicProxy;
import com.hql.proxyhelper.proxy.Excavate;
import com.hql.proxyhelper.proxy.ExcavateWorker;
import com.hql.proxyhelper.proxy.ProxyHelper;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        ProxyHelper.getInstance().BuildWall();
        ProxyHelper.getInstance().Excavate();

    }


}