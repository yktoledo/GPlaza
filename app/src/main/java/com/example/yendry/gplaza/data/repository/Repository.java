package com.example.yendry.gplaza.data.repository;

import com.example.yendry.gplaza.domain.model.User;

import java.util.List;

import io.reactivex.Observable;

public interface Repository {
    Observable<List<User>> getUserList();
}
