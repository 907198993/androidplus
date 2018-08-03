package com.paimo.androidplus.ui.activity;

import com.avos.avoscloud.AVUser;
import com.paimo.androidplus.MainActivity;
import com.paimo.androidplus.R;
import com.paimo.androidplus.data.model.User;

public class SplashActivity extends BaseActivity {
    private  static final int DELAY_TIME = 2000;

    @Override
    public int getLayoutResId() {
        return R.layout.activity_splash;
    }


    @Override
    protected void init() {
        super.init();
        setStatusBarTransparent();
        User currentUser = AVUser.getCurrentUser(User.class);
        if(currentUser == null){
            navigateToLoginActivity();
        }else {
            //延时跳转到主界面
            navigateToMainActivity();
        }

        //Activity 转场动画，淡入淡出
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    /**
     * 延时跳转到主界面
     */
    private void navigateToMainActivity() {
        postDelay(new Runnable() {
            @Override
            public void run() {
                //跳转到主界面
                navigateTo(MainActivity.class);
            }
        }, DELAY_TIME);
    }

    /**
     * 延时跳转到登陆界面
     */
    private void navigateToLoginActivity() {
        postDelay(new Runnable() {
            @Override
            public void run() {
                //跳转到主界面
                navigateTo(LoginActivity.class);
            }
        },DELAY_TIME);

    }
}
