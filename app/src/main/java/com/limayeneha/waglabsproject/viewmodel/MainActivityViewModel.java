package com.limayeneha.waglabsproject.viewmodel;

import com.limayeneha.waglabsproject.utils.StackOverflowApiInterface;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by limayeneha on 3/13/19.
 */

public class MainActivityViewModel extends BaseViewModel<MainActivityView> {

    private StackOverflowApiInterface stackOverflowApiInterface;

    public MainActivityViewModel(StackOverflowApiInterface stackOverflowApiInterface) {
        this.stackOverflowApiInterface = stackOverflowApiInterface;
    }

    public void listUsers(String siteName) {
        compositeDisposable.add(stackOverflowApiInterface.listUsers(siteName)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(usersResponse -> view.load(usersResponse.getItems()),
                        throwable -> view.error(throwable)));

    }
}
