package com.limayeneha.waglabsproject.utils;

import com.limayeneha.waglabsproject.model.UsersResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by limayeneha on 3/11/19.
 */

public interface StackOverflowApiInterface {
    @Headers("Cache-Control: public, max-age=640000, s-maxage=640000 , max-stale=2419200")
    @GET("users")
    Observable<UsersResponse> listUsers(@Query("site") String siteName);
}
