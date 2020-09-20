package com.example.eventbus;

import android.view.View;
import android.widget.TextView;

import com.example.eventbus.eventbus.BindEventBus;
import com.example.eventbus.eventbus.Event;
import com.example.eventbus.eventbus.EventB;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

@BindEventBus
public class FragmentB extends BaseFragment {
    TextView textView;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_b;
    }

    @Override
    protected void initView(View view) {
        textView = view.findViewById(R.id.tv_receive);
       // textView.setText("");
    }

    @Subscribe(threadMode = ThreadMode.MAIN_ORDERED, sticky = false, priority = 1)
    public void handleEvent(Event event) {
        textView.setText((String) event.getData());
    }
    @Subscribe(threadMode = ThreadMode.MAIN_ORDERED, sticky = false, priority = 1)
    public void handleEventB(EventB eventB){
        textView.setText(eventB.getMsg());
    }
    @Subscribe(threadMode = ThreadMode.MAIN_ORDERED, sticky = false, priority = 1)
    public void handleEventB2(EventB eventB){
        textView.setText(eventB.getMsg());
    }
}
