package com.limayeneha.waglabsproject.viewmodel;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by limayeneha on 3/13/19.
 */

public class BaseViewModel<T extends IView> {

    protected CompositeDisposable compositeDisposable;
    T view;

    public BaseViewModel() {
        compositeDisposable = new CompositeDisposable();
    }

    public void attach(T view) {
        this.view = view;
    }

    public void detach() {
        view = null;
    }

    public void clearSubscriptions() {
        compositeDisposable.clear();
    }


}
