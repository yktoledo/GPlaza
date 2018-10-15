package com.example.yendry.gplaza.base;

import android.arch.lifecycle.ViewModel;

public abstract class BaseViewModel<T extends BaseFragment> extends ViewModel {

    protected T fragment;


    public BaseViewModel() {

    }

    public void setFragment(T fragment) {
        this.fragment = fragment;
    }

    public abstract void init();

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}