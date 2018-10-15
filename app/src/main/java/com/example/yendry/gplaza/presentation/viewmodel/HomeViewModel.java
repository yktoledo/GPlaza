package com.example.yendry.gplaza.presentation.viewmodel;

import android.util.Log;
import android.widget.Toast;

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
                if (users != null && users.size()>0) {
                    fragment.showList(users);
                }
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: ");
                Toast.makeText(fragment.getContext(), "Ooops, we have network problems", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onComplete() {
                fragment.showProgress(false);
            }
        }, null);
    }


}
