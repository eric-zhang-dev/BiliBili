package com.java.bilibili.ui.splash;

import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.bilibili.magicasakura.widgets.TintButton;
import com.java.bilibili.R;
import com.java.bilibili.base.BaseActivity;
import com.java.bilibili.ui.main.MainActivity;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;


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

//        Flowable<Integer> upstream = Flowable.create(new FlowableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(FlowableEmitter<Integer> emitter) throws Exception {
//                Log.d(TAG, "emit 1");
//                emitter.onNext(1);
//                Log.d(TAG, "emit 2");
//                emitter.onNext(2);
//                Log.d(TAG, "emit 3");
//                emitter.onNext(3);
//                Log.d(TAG, "emit complete");
//                emitter.onComplete();
//            }
//        }, BackpressureStrategy.ERROR); //增加了一个参数
//
//        Subscriber<Integer> downstream = new Subscriber<Integer>() {
//
//            @Override
//            public void onSubscribe(Subscription s) {
//                Log.d(TAG, "onSubscribe");
//                s.request(Long.MAX_VALUE);  //注意这句代码
//            }
//
//            @Override
//            public void onNext(Integer integer) {
//                Log.d(TAG, "onNext: " + integer);
//
//            }
//
//            @Override
//            public void onError(Throwable t) {
//                Log.w(TAG, "onError: ", t);
//            }
//
//            @Override
//            public void onComplete() {
//                Log.d(TAG, "onComplete");
//            }
//        };
//
//        upstream.subscribeWith(downstream);
        String aa = "fkjdsalijfofldaJFOIEjfldanlJR2OnfldajilwafkndaIUPO32,LFKjlijuJFLMA";
        char[] a = aa.toCharArray();
        Observable.create((ObservableOnSubscribe<Character>) e -> {
            for (int i = 0; i < a.length; i++) {
                e.onNext(a[i]);
            }
        })
                .delay(5, TimeUnit.SECONDS)
                .map(character -> {
            if (character >= 'a' && character <= 'z') {
                return character.toString().toUpperCase();
            }else {
                return character.toString();
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s ->
                        Log.e(TAG, s));
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
