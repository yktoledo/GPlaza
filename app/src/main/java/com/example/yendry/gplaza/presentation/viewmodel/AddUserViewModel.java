package com.example.yendry.gplaza.presentation.viewmodel;

import android.util.Log;
import android.widget.Toast;

import com.example.yendry.gplaza.base.BaseViewModel;
import com.example.yendry.gplaza.domain.model.UserEntity;
import com.example.yendry.gplaza.domain.model.UserEntityResponse;
import com.example.yendry.gplaza.domain.usecases.CreateUseCase;
import com.example.yendry.gplaza.presentation.view.AddUserFragment;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;

public class AddUserViewModel extends BaseViewModel<AddUserFragment> {

    private static final String TAG = AddUserViewModel.class.getSimpleName();
    CreateUseCase useCase;

    @Inject public AddUserViewModel(CreateUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public void init() {
//        createUser(new UserEntity("name", "layer"));
    }

    public void createUser(UserEntity user){
        useCase.execute(new DisposableObserver<UserEntityResponse>() {
            @Override
            public void onNext(UserEntityResponse userEntityResponse) {
                Log.d(TAG, "onNext: "+userEntityResponse);
                fragment.cleanData();
                Toast.makeText(fragment.getContext(), "User was added succesfully", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(fragment.getContext(), "Ooops, try again!!", Toast.LENGTH_SHORT).show();

                Log.d(TAG, "onError: ");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: ");
                fragment.showProgress(false);
            }
        }, user);
    }
}
