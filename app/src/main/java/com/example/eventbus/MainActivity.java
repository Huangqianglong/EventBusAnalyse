package com.example.eventbus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.eventbus.annoationtest.AnnotationTest;
import com.example.eventbus.annoationtest.AnnotationTestUtils;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Fragment mFragmentA, mFragmentB;
    FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFragmentA = new FragmentA();
        mFragmentB = new FragmentB();
        mFragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.add(R.id.fl_a, mFragmentA, mFragmentA.getClass().getName());
        transaction.add(R.id.fl_b, mFragmentB, mFragmentB.getClass().getName());
        transaction.commit();
    }

    public void onTvClick(View view) {
        Log.d("hql", "点击事件");
        AnnotationTest annotation = new AnnotationTest();
        annotation.setName("abcefgddddd");
        annotation.setPasdword("1234567890ddddddd");

        try {
            AnnotationTestUtils.valid(annotation);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
