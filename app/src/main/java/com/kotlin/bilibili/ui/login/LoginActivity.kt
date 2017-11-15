//package com.d.m.system.ui.login
//
//import android.content.Intent
//import android.support.v4.content.ContextCompat.startActivity
//import android.text.TextUtils
//import android.view.View
//import android.widget.Toast
//import com.d.m.system.http.ServerAddress.Companion.login
//import com.d.m.system.manager.AppManager
//import com.d.m.system.ui.login.impl.LoginImpl
//import com.d.m.system.ui.login.presenter.LoginPresenter
//import com.d.m.system.ui.main.MainActivity
//import com.d.m.system.utils.Constent
//import com.d.m.system.utils.MD5
//import com.d.m.system.utils.SharedUtils
//import com.kotlin.bilibili.R
//import com.kotlin.bilibili.base.RxBaseActivity
//
//class LoginActivity : RxBaseActivity<LoginPresenter>(), View.OnClickListener, LoginImpl.View {
//    override fun showLoading() {
//    }
//
//    override fun showError(msg: String?) {
//        Toast.makeText(mActivity, msg, Toast.LENGTH_LONG).show()
//    }
//
//    override fun initLoginInfo(data: String) {
//        if (TextUtils.isEmpty(data)) {
//            showError("服务器异常")
//        } else {
//            SharedUtils.putString(mActivity, Constent.SECTION_ID, data)
//            startActivity(Intent(this, MainActivity::class.java))
//            finish()
//        }
//    }
//
//    override fun setPresenter(): LoginPresenter {
//        return LoginPresenter()
//    }
//
//    override fun layout(): Int = R.layout.ui_login
//
//    override fun onClick(v: View?) {
//        when (v!!.id) {
//            R.id.login -> {
//                if (TextUtils.isEmpty(user_name.text)) return
//                if (TextUtils.isEmpty(pass_word.text)) return
//                mPresenter.login(user_name.text.toString(), MD5.md5(pass_word.text.toString()))
//            }
//        }
//    }
//
//
//    override fun initData() {
//        AppManager.appManager.finishOthersActivity(LoginActivity::class.java)
//        login.setOnClickListener(this)
//        if (!TextUtils.isEmpty(SharedUtils.getString(mActivity, Constent.SECTION_ID, ""))) {
//            startActivity(Intent(this, MainActivity::class.java))
//            finish()
//        }
//    }
//
//}
