package com.spaja.oauthexample.main_activity;

/**
 * Created by Spaja on 17-Oct-17.
 */

class Presenter {

    private EggsRepository repository;

    Presenter(EggsRepository repository) {
        this.repository = repository;
    }

    void getEggs() {
        repository.getEggs();
    }
}



