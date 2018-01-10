package com.java.bilibili.ui.splash;

import android.content.Intent;
import android.view.View;

import com.bilibili.magicasakura.widgets.TintButton;
import com.java.bilibili.R;
import com.java.bilibili.base.BaseActivity;
import com.java.bilibili.ui.main.MainActivity;

import butterknife.BindView;


public class SplashActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.btn_register)
    TintButton btn_register;

    @Override
    protected int getLayout() {
        return R.layout.ui_activity_login;
    }

    @Override
    protected void initEventAndData() {
        btn_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_register:
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
    }
}
