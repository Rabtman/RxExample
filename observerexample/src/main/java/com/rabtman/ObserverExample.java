package com.rabtman;

import com.rabtman.normal.Watched;
import com.rabtman.normal.WatchedImpl;
import com.rabtman.normal.Watcher;
import com.rabtman.normal.WatcherImpl;
import com.rabtman.observable.MyObservable;
import com.rabtman.observable.MyObserver;

import rx.Observable;
import rx.Subscriber;

public class ObserverExample {
    public static void main(String[] var0) {
        //普通版观察者模式
        Watched watched = new WatchedImpl();
        Watcher A = new WatcherImpl();
        Watcher B = new WatcherImpl();

        watched.addWatcher(A);
        watched.addWatcher(B);

        watched.notifyWatchers("help!");

        System.out.println("----------------------------");
        //java api
        MyObservable myObservable = new MyObservable();
        MyObserver C = new MyObserver(myObservable);
        MyObserver D = new MyObserver(myObservable);

        myObservable.sendMsg("help help!!");

        System.out.println("----------------------------");

        //rxjava
        Observable<String> rxObservable = Observable.create(
                new Observable.OnSubscribe<String>() {
                    @Override
                    public void call(Subscriber<? super String> subscriber) {
                        subscriber.onNext("help help help!!!");
                        subscriber.onCompleted();
                    }
                }
        );

        Subscriber<String> E = new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                System.out.println(s);
            }
        };

        Subscriber<String> F = new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                System.out.println(s);
            }
        };

        rxObservable.subscribe(E);
        rxObservable.subscribe(F);
    }
}
