package com.rabtman;

import com.rabtman.normal.Watched;
import com.rabtman.normal.Watcher;
import com.rabtman.observable.Customer;
import com.rabtman.observable.Waiter;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * @author Rabtman
 * 熟悉观察者模式
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
        new ObservableOnSubscribe<String>() {
          @Override
          public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Exception {
            emitter.onNext("Customer-Rabtman-order dishes!!!");
            emitter.onComplete();
          }
        }
    );

    Observer<String> E = new Observer<String>() {
      @Override
      public void onSubscribe(@NonNull Disposable d) {

      }

      @Override
      public void onNext(@NonNull String s) {
        System.out.println("Waiter-E: " + s);
      }

      @Override
      public void onError(@NonNull Throwable e) {

      }

      @Override
      public void onComplete() {

      }
    };

    Consumer<String> F = new Consumer<String>() {
      @Override
      public void accept(@NonNull String s) throws Exception {
        System.out.println("Waiter-F: " + s);
      }
    };

    customer.subscribe(E);
    customer.subscribe(F);
  }
}
