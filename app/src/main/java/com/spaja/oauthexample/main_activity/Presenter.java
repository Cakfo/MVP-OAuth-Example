package com.spaja.oauthexample.main_activity;

import com.spaja.oauthexample.model.Response;
import com.spaja.oauthexample.model.Token;
import com.spaja.oauthexample.networking.ChickenFarmAPI;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Spaja on 17-Oct-17.
 */

class Presenter {

    private EggsRepository repository;
    private View view;

    Presenter(EggsRepository repository, final View view) {
        this.repository = repository;
        this.view = view;
    }

    void getEggs() {

        repository.getEggsReactively()
                .flatMap(new Function<Token, Single<Response>>() {
                    @Override
                    public Single<Response> apply(@NonNull Token token) throws Exception {
                        return ChickenFarmAPI.serviceReact.collectEggsReact(EggsRepositoryImpl.USER_ID, "Bearer " + token.getAccessToken());
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Response>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onSuccess(@NonNull Response response) {
                        view.displayEggsMessage(response.getMessage());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }
                });
    }
}



