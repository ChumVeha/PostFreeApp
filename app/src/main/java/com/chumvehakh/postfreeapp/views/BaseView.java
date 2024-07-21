package com.chumvehakh.postfreeapp.views;

public interface BaseView {
    void onLoading();
    void onHidingLoading();
    void onError(String message);
    void onSuccess(Object message);
}