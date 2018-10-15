package com.example.yendry.gplaza.domain.usecases;



import com.example.yendry.gplaza.data.net.NetRepository;
import com.example.yendry.gplaza.domain.UseCase;
import com.example.yendry.gplaza.domain.model.User;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class GetListUseCase extends UseCase<List<User>, Void> {


    private NetRepository repository;

    @Inject public GetListUseCase(NetRepository repository) {
        this.repository = repository;
    }


    @Override
    public Observable<List<User>> createObservableUseCase(Void aVoid) {
        return repository.getUserList();
    }

}
