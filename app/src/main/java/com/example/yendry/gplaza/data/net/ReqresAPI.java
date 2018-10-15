package com.example.yendry.gplaza.data.net;


import com.example.yendry.gplaza.domain.model.ListResponse;
import com.example.yendry.gplaza.domain.model.User;
import com.example.yendry.gplaza.domain.model.UserEntity;
import com.example.yendry.gplaza.domain.model.UserEntityResponse;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ReqresAPI {
    @GET("api/users")
    Observable<ListResponse> getUserList();
    @POST("api/users")
    Observable<UserEntityResponse> createUser(@Body UserEntity user);
}
