package com.paimo.androidplus.di;

import com.paimo.androidplus.ui.activity.LoginActivity;
import com.paimo.androidplus.ui.activity.RegisterActivity;
import com.paimo.androidplus.ui.activity.SplashActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public  abstract  class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector
    abstract SplashActivity splashActivity();


    @ActivityScoped
    @ContributesAndroidInjector
    abstract RegisterActivity registerActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract LoginActivity loginActivity();

}
