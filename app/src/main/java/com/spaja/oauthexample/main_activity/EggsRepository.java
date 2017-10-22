package com.spaja.oauthexample.main_activity;

import com.spaja.oauthexample.model.Response;
import com.spaja.oauthexample.model.Token;

import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * Created by Spaja on 17-Oct-17.
 */

interface EggsRepository {

    //void getEggs();

    Single<Token> getEggsReactively();

}
