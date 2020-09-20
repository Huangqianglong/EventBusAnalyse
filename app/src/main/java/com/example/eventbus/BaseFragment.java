package com.example.eventbus;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.eventbus.eventbus.BindEventBus;
import com.example.eventbus.eventbus.EventBusUtils;

public abstract class BaseFragment extends Fragment {
    protected abstract int getLayoutId();
    protected abstract void initView(View view);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(this.getClass().isAnnotationPresent(BindEventBus.class)){
            EventBusUtils.register(this); //必需要先注册
        }
        return inflater.inflate(getLayoutId(), container, false);
        //return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(this.getClass().isAnnotationPresent(BindEventBus.class)){
            EventBusUtils.unregister(this); //必需要先注册
        }
    }
}
