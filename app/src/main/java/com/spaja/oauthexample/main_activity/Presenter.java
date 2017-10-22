package com.spaja.oauthexample.main_activity;

import com.spaja.oauthexample.model.Response;
import com.spaja.oauthexample.model.Token;
import com.spaja.oauthexample.networking.ChickenFarmAPI;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Spaja on 17-Oct-17.
 */

class Presenter {

    private EggsRepository repository;
    private View view;
    private CompositeDisposable disposable;

    Presenter(EggsRepository repository, final View view) {
        this.repository = repository;
        this.view = view;
        disposable = new CompositeDisposable();
    }

    void getEggs() {

        disposable.add(repository.getEggsReactively()
                .flatMap(new Function<Token, Single<Response>>() {
                    @Override
                    public Single<Response> apply(@NonNull Token token) throws Exception {
                        return ChickenFarmAPI.serviceReact.collectEggsReact(EggsRepositoryImpl.USER_ID, "Bearer " + token.getAccessToken());
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<Response>() {
                    @Override
                    public void onSuccess(@NonNull Response response) {
                        view.displayEggsMessage(response.getMessage());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }
                }));
    }

    void clearResources() {
        disposable.clear();
    }
}



