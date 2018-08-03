package com.paimo.androidplus.presenter;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.SignUpCallback;
import com.paimo.androidplus.contract.RegisterContract;
import com.paimo.androidplus.data.model.User;

import javax.inject.Inject;

public class RegisterPresenter  implements RegisterContract.Presenter{

    private  RegisterContract.View mView;

    @Inject
    public RegisterPresenter(){}


    @Override
    public void register(String userName, String password) {
         final User user = new User();
         user.setUsername(userName);
         user.setPassword(password);
         user.signUpInBackground(new SignUpCallback() {
             @Override
             public void done(AVException e) {
                 if (e == null) {
                     mView.onRegisterSuccess();
                 } else {
                     if (e.getCode() == AVException.USERNAME_TAKEN) {
                         mView.onUserNameTaken();
                     } else {
                         mView.onRegisterFailed();
                     }
                 }
             }
         });

    }

    @Override
    public void takeView(RegisterContract.View view) {
        mView = view;
    }

    @Override
    public void dropView() {
        mView = null;
    }
}
