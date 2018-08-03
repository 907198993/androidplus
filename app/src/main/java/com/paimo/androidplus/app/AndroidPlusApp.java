package com.paimo.androidplus.app;

import com.paimo.androidplus.di.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class AndroidPlusApp extends DaggerApplication {

    private static final String APP_ID = "e23RXU0ywb3H2hfHgPbmAL3s-gzGzoHsz";
    private static final String APP_KEY = "Hy5zNJf0I4oOAwUA7k7sf1CN";

    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.create();
    }
}
