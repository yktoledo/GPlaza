package com.example.yendry.gplaza.data.net;

import com.example.yendry.gplaza.data.repository.Repository;
import com.example.yendry.gplaza.domain.model.ListResponse;
import com.example.yendry.gplaza.domain.model.User;
import com.example.yendry.gplaza.domain.model.UserEntity;
import com.example.yendry.gplaza.domain.model.UserEntityResponse;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class NetRepository implements Repository {

    ReqresAPI reqresAPI;

   @Inject public NetRepository(ReqresAPI reqresAPI) {
        this.reqresAPI = reqresAPI;
    }

    @Override
    public Observable<List<User>> getUserList() {
      return reqresAPI.getUserList().map(new Function<ListResponse, List<User>>() {
           @Override
           public List<User> apply(ListResponse listResponse) throws Exception {
               return listResponse.getData();
           }
       });

    }

    @Override
    public Observable<UserEntityResponse> createUser(UserEntity user) {
        return reqresAPI.createUser(user);
    }


}
