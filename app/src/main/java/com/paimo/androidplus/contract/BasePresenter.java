package com.paimo.androidplus.contract;

public interface BasePresenter<T> {
    void takeView(T view);
    void dropView();
}
