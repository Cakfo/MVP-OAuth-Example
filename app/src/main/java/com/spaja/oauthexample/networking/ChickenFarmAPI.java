package com.spaja.oauthexample.networking;

import com.spaja.oauthexample.model.Response;
import com.spaja.oauthexample.model.Token;

import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Spaja on 31-Jul-17.
 */

public interface ChickenFarmAPI {

    String BASE_URL = "http://coop.apps.knpuniversity.com/";

//    Retrofit retrofit = new Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build();
//    ChickenFarmAPI service = retrofit.create(ChickenFarmAPI.class);
//
//    @FormUrlEncoded
//    @POST("token")
//    Call<Token> getToken(@Field("client_id") String clientId,
//                         @Field("client_secret") String clientSecret,
//                         @Field("grant_type") String grantType);
//
//    @POST("api/{user_id}/eggs-collect")
//    Call<Response> collectEggs(@Path("user_id") String clientId, @Header("Authorization") String token);

    Retrofit retrofitReact = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();
    ChickenFarmAPI serviceReact = retrofitReact.create(ChickenFarmAPI.class);

    @POST("api/{user_id}/eggs-collect")
    Single<Response> collectEggsReact(@Path("user_id") String clientId, @Header("Authorization") String token);

    @FormUrlEncoded
    @POST("token")
    Single<Token> getTokenReact(@Field("client_id") String clientId,
                                @Field("client_secret") String clientSecret,
                                @Field("grant_type") String grantType);
}

