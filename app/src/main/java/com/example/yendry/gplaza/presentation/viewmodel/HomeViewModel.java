package com.example.yendry.gplaza.presentation.viewmodel;

import android.util.Log;

import com.example.yendry.gplaza.base.BaseViewModel;
import com.example.yendry.gplaza.domain.model.User;
import com.example.yendry.gplaza.domain.usecases.GetListUseCase;
import com.example.yendry.gplaza.presentation.view.HomeFragment;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;

public class HomeViewModel extends BaseViewModel<HomeFragment> {

    private static final String TAG = HomeViewModel.class.getSimpleName();
    GetListUseCase useCase;

    @Inject public HomeViewModel(GetListUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public void init() {
        useCase.execute(new DisposableObserver<List<User>>() {
            @Override
            public void onNext(List<User> users) {
                Log.d(TAG, "onNext: "+users);
                fragment.showList(users);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: ");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: ");
                fragment.showProgress(false);
            }
        }, null);
    }


}
