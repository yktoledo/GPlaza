package com.example.yendry.gplaza.domain.usecases;


import com.example.yendry.gplaza.data.net.NetRepository;
import com.example.yendry.gplaza.domain.UseCase;
import com.example.yendry.gplaza.domain.model.UserEntity;
import com.example.yendry.gplaza.domain.model.UserEntityResponse;

import javax.inject.Inject;

import io.reactivex.Observable;

public class CreateUseCase extends UseCase<UserEntityResponse, UserEntity> {


    private NetRepository repository;

    @Inject public CreateUseCase(NetRepository repository) {
        this.repository = repository;
    }


    @Override
    public Observable<UserEntityResponse> createObservableUseCase(UserEntity userEntity) {
        return repository.createUser(userEntity);
    }
}
