package com.java.bilibili.ui.splash;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.bilibili.magicasakura.widgets.TintButton;
import com.java.bilibili.R;
import com.java.bilibili.base.BaseActivity;
import com.java.bilibili.ui.main.MainActivity;
import com.java.bilibili.widget.test.MyViewGroupA;
import com.java.bilibili.widget.test.MyViewGroupB;
import com.java.bilibili.widget.test.TestView;

import butterknife.BindView;


public class SplashActivity extends BaseActivity implements View.OnClickListener {
    String TAG = this.getClass().getSimpleName();
    @BindView(R.id.btn_register)
    TintButton btn_register;
//    @BindView(R.id.b)
//    MyViewGroupB bb;
//    @BindView(R.id.a)
//    MyViewGroupA aa;
//    @BindView(R.id.c)
//    TestView c;

    @Override
    protected int getLayout() {
        return R.layout.ui_activity_login;
    }

    @Override
    protected void initEventAndData() {
        btn_register.setOnClickListener(this);
//        bb.setOnClickListener(this);
//        aa.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                Log.e(TAG, "A-->onTouch: setOnTouchListener" + motionEvent.getAction());
//                return false;
//            }
//        });
//        bb.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                Log.e(TAG, "B-->onTouch: setOnTouchListener" + motionEvent.getAction());
//                return false;
//            }
//        });
//        c.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                Log.e(TAG, "C-->onTouch: setOnTouchListener" + motionEvent.getAction());
//                return false;
//            }
//        });
//        aa.setOnClickListener(this);
//        bb.setOnClickListener(this);
//        c.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_register:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.b:
                Log.e(TAG, "B-->onClick: setOnTouchListener");
                break;
            case R.id.a:
                Log.e(TAG, "A-->onClick: setOnTouchListener");
                break;
            case R.id.c:
                Log.e(TAG, "C-->onClick: setOnTouchListener");
                break;
        }
    }
}
