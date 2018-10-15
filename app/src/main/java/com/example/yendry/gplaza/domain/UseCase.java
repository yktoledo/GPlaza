package com.example.yendry.gplaza.domain;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public abstract class UseCase<T, Params> {

    private final CompositeDisposable compositeDisposable;

    public UseCase() {
        compositeDisposable = new CompositeDisposable();
    }

    public abstract Observable<T> createObservableUseCase(Params params);

    public void execute(DisposableObserver<T> observer, Params params) {
        Observable<T> observable = createObservableUseCase(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        addDisposable(observable.subscribeWith(observer));
    }

    private void addDisposable(Disposable observer) {
        if (observer != null) {
            compositeDisposable.add(observer);
        }
    }

    public void dispose(){
        if (!compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }
}
