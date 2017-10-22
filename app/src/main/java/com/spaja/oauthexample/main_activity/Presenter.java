package com.spaja.oauthexample.main_activity;

import com.spaja.oauthexample.model.Token;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
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
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new SingleObserver<Token>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onSuccess(@NonNull Token token) {
                        view.displayEggsMessageToken(token.getAccessToken());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }
                });
    }
}



