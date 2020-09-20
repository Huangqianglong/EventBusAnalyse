package com.example.eventbus;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.eventbus.eventbus.BindEventBus;
import com.example.eventbus.eventbus.Event;
import com.example.eventbus.eventbus.EventB;
import com.example.eventbus.eventbus.EventBusUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


@BindEventBus
public class FragmentA extends BaseFragment {
    TextView mTvA, mTvB;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_a;
    }

    @Override
    protected void initView(View view) {
        mTvA = view.findViewById(R.id.tv_a);
        mTvA.setOnClickListener(mClickListener);
        mTvB = view.findViewById(R.id.tv_b);
        mTvB.setOnClickListener(mClickListener);
    }

    public void onClickA(View v) {
        Log.d("hql", "点击事件A");
    }

    View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tv_a:
                    sendEvent2B();
                    break;
                case R.id.tv_b:
                    EventBus.getDefault().post(new EventB("这是A发过来的消息B"));
                    break;
                default:
                    break;
            }
        }
    };

    private void sendEvent2B() {
        Log.d("hql", "发送eventBus 事件");
        Event<String> event = new Event<>(1, "这是从A发过来的消息");
        EventBusUtils.sendEvent(event);
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true, priority = 1)
    public void handleEvntBus(Event event) {

    }
}
