package com.java.bilibili.ui.splash;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.bilibili.magicasakura.widgets.TintButton;
import com.java.bilibili.R;
import com.java.bilibili.base.BaseActivity;
import com.java.bilibili.ui.main.MainActivity;
import com.java.bilibili.widget.test.MyViewGroupB;

import butterknife.BindView;


public class SplashActivity extends BaseActivity implements View.OnClickListener {
        @BindView(R.id.btn_register)
    TintButton btn_register;
//    @BindView(R.id.b)
//    MyViewGroupB bb;

    @Override
    protected int getLayout() {
        return R.layout.ui_activity_login;
    }

    @Override
    protected void initEventAndData() {
        btn_register.setOnClickListener(this);
//        bb.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_register:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.b:
                Toast.makeText(this, "adfsaf", Toast.LENGTH_LONG).show();
                break;
        }
    }
}
