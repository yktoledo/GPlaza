package com.example.yendry.gplaza.data.repository;

import com.example.yendry.gplaza.domain.model.User;
import com.example.yendry.gplaza.domain.model.UserEntity;
import com.example.yendry.gplaza.domain.model.UserEntityResponse;

import java.util.List;

import io.reactivex.Observable;

public interface Repository {
    Observable<List<User>> getUserList();
    Observable<UserEntityResponse> createUser(UserEntity user);
}
