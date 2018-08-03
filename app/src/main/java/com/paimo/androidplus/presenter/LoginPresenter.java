package com.paimo.androidplus.presenter;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.LogInCallback;
import com.paimo.androidplus.contract.LoginContract;

import javax.inject.Inject;

public class LoginPresenter implements LoginContract.Presenter{

    private LoginContract.View mView;

    @Inject
    public LoginPresenter() {
    }


    @Override
    public void login(String userName, String password) {

        AVUser.logInInBackground(userName, password, new LogInCallback<AVUser>() {
            @Override
            public void done(AVUser avUser, AVException e) {
                if(e==null){
                    mView.onLoginSuccess();
                }else{
                    handleError(e.getCode());
                }
            }
        });

    }

    private  void handleError(int code ){
        switch (code){
            case AVException.USERNAME_PASSWORD_MISMATCH:
                mView.onUserNamePasswordMismatch();
            case AVException.USER_DOESNOT_EXIST:
                mView.onUserNameDoesNotExist();
                break;
            default:
                mView.onLoginFailed();

        }
    }

    @Override
    public void takeView(LoginContract.View view) {
        mView= view;
    }

    @Override
    public void dropView() {
        mView = null;
    }
}
