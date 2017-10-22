package com.spaja.oauthexample.main_activity;

import com.spaja.oauthexample.model.Response;
import com.spaja.oauthexample.model.Token;
import com.spaja.oauthexample.networking.ChickenFarmAPI;

import io.reactivex.Single;
import retrofit2.Call;

/**
 * Created by Spaja on 17-Oct-17.
 */

class EggsRepositoryImpl implements EggsRepository {

    public static final String CLIENT_ID = "OAuthExample";
    public static final String CLIENT_SECRET = "d52b1249416c66b287a6ac54529ad84d";
    public static final String USER_ID = "2110";
    private Call<Token> tokenCall;
    private Call<Response> responseCall;

    //    @Override
//    public void getEggs() {
//
//        tokenCall = ChickenFarmAPI.service.getToken(CLIENT_ID, CLIENT_SECRET, "client_credentials");
//
//        tokenCall.enqueue(new Callback<Token>() {
//            @Override
//            public void onResponse(Call<Token> call, retrofit2.Response<Token> response) {
//
//                responseCall = ChickenFarmAPI.service.collectEggs(USER_ID, "Bearer " + response.body().getAccessToken());
//                responseCall.enqueue(new Callback<Response>() {
//                    @Override
//                    public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
//                        view.displayEggsMessage(response.body());
//                    }
//
//                    @Override
//                    public void onFailure(Call<Response> call, Throwable t) {
//                        int o = 1;
//                    }
//                });
//            }
//
//            @Override
//            public void onFailure(Call<Token> call, Throwable t) {
//                int o = 1;
//            }
//        });
//    }

    @Override
    public Single<Token> getEggsReactively() {

        return ChickenFarmAPI
                .serviceReact
                .getTokenReact(CLIENT_ID, CLIENT_SECRET, "client_credentials");
    }
}
