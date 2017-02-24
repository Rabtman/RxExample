package com.rabtman;

import com.rabtman.normal.Watched;
import com.rabtman.normal.Watcher;
import com.rabtman.observable.Customer;
import com.rabtman.observable.Waiter;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;

/**
 * @author Rabtman
 */

public class Part1 {

    public Part1() {
        normal();
        System.out.println("----------------------------");
        javaApi();
        System.out.println("----------------------------");
        rxJava();
    }

    //自己实现的观察者模式
    private void normal() {
        Watched watched = new com.rabtman.normal.Customer("Rabtman");
        Watcher A = new com.rabtman.normal.Waiter("A");
        Watcher B = new com.rabtman.normal.Waiter("B");

        watched.addWatcher(A);
        watched.addWatcher(B);

        watched.notifyWatchers("order dishes!");
    }

    private void javaApi() {
        Customer customer = new Customer("Rabtman");
        Waiter C = new Waiter("C", customer);
        Waiter D = new Waiter("D", customer);

        customer.call("order dishes!!");
    }

    private void rxJava() {
        Observable<String> customer = Observable.create(
                new Observable.OnSubscribe<String>() {
                    @Override
                    public void call(Subscriber<? super String> subscriber) {
                        subscriber.onNext("Customer-Rabtman-order dishes!!!");
                        subscriber.onCompleted();
                    }
                }
        );

        Observer<String> E = new Observer<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                System.out.println("Waiter-E: " + s);
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
                System.out.println("Waiter-F: " + s);
            }
        };

        customer.subscribe(E);
        customer.subscribe(F);
    }
}
