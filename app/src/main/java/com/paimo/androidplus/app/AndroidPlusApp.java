package com.paimo.androidplus.app;

import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVUser;
import com.paimo.androidplus.BuildConfig;
import com.paimo.androidplus.data.model.User;
import com.paimo.androidplus.di.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class AndroidPlusApp extends DaggerApplication {

    private static final String APP_ID = "e23RXU0ywb3H2hfHgPbmAL3s-gzGzoHsz";
    private static final String APP_KEY = "Hy5zNJf0I4oOAwUA7k7sf1CN";

    @Override
    public void onCreate() {
        super.onCreate();
        initSubClasses();
        AVOSCloud.initialize(this,APP_ID,APP_KEY);
        AVOSCloud.setDebugLogEnabled(BuildConfig.DEBUG);

    }

    private void initSubClasses() {
        AVObject.registerSubclass(User.class);
        AVUser.alwaysUseSubUserClass(User.class);
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.create();
    }
}
