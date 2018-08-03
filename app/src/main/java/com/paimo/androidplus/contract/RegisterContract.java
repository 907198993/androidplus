package com.paimo.androidplus.contract;

public interface RegisterContract {

    interface View extends BaseView{
        void onRegisterSuccess();//注册成功
        void onRegisterFailed();//注册失败
        void onUserNameTaken();//用户名被占用

    }

    interface  Presenter extends  BasePresenter<View>{

        void register(String email,String password);//注册

    }
}
