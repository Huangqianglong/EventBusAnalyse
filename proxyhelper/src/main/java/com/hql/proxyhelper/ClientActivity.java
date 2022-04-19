package com.hql.proxyhelper;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.hql.proxyhelper.proxy.ProxyHelper;

public class ClientActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);


    }

    public void buyJPCamera(View view) {

       int price = ProxyHelper.getInstance().buyJapanCamera();
        Log.d("hql", "客户端  购买日本相机  花"+price);
    }
    public void buyKRCamera(View view) {

        int price = ProxyHelper.getInstance().buyKoreaCamera();
        Log.d("hql", "客户端  购买韩国相机 花"+price);
    }

}