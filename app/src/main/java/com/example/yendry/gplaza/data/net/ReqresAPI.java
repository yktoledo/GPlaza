package com.example.yendry.gplaza.data.net;


import com.example.yendry.gplaza.domain.model.ListResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ReqresAPI {
    @GET("api/users")
    Observable<ListResponse> getUserList();
}
