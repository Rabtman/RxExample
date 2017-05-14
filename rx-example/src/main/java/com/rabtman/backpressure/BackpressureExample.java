package com.rabtman.backpressure;

import android.os.SystemClock;
import android.util.Log;
import com.rabtman.MainActivity;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * @author Rabtman 关于背压
 */

public class BackpressureExample {

  //背压异常
  public void showRxBackpressureException() {
    Observable.interval(1, TimeUnit.MILLISECONDS)
        .observeOn(Schedulers.newThread())
        .subscribe(new Action1<Long>() {
          @Override
          public void call(Long aLong) {
            SystemClock.sleep(1000);
            Log.d(MainActivity.TAG, "<--------" + aLong + "--------->");
          }
        }, new Action1<Throwable>() {
          @Override
          public void call(Throwable throwable) {
            throwable.printStackTrace();
          }
        });
  }

  //onBackpressureBuffer
  public void showOnBackpressureBuffer() {
    Observable.interval(1, TimeUnit.MILLISECONDS)
        .onBackpressureBuffer()
        .observeOn(Schedulers.newThread())
        .subscribe(new Action1<Long>() {
          @Override
          public void call(Long aLong) {
            SystemClock.sleep(1000);
            Log.d(MainActivity.TAG, "<--------" + aLong + "--------->");
          }
        }, new Action1<Throwable>() {
          @Override
          public void call(Throwable throwable) {
            throwable.printStackTrace();
          }
        });
  }

  //onBackpressureLatest
  public void showOnBackpressureLatest() {
    Observable.interval(1, TimeUnit.MILLISECONDS)
        .onBackpressureLatest()
        .observeOn(Schedulers.newThread())
        .subscribe(new Action1<Long>() {
          @Override
          public void call(Long aLong) {
            SystemClock.sleep(1000);
            Log.d(MainActivity.TAG, "<--------" + aLong + "--------->");
          }
        }, new Action1<Throwable>() {
          @Override
          public void call(Throwable throwable) {
            throwable.printStackTrace();
          }
        });
  }

  //onBackpressureDrop
  public void showOnBackpressureDrop() {
    Observable.interval(1, TimeUnit.MILLISECONDS)
        .onBackpressureDrop()
        .observeOn(Schedulers.newThread())
        .subscribe(new Action1<Long>() {
          @Override
          public void call(Long aLong) {
            SystemClock.sleep(1000);
            Log.d(MainActivity.TAG, "<--------" + aLong + "--------->");
          }
        }, new Action1<Throwable>() {
          @Override
          public void call(Throwable throwable) {
            throwable.printStackTrace();
          }
        });
  }

  //响应式拉取
  public void showReactivePull() {
    Observable.range(0, 10000)
        .observeOn(Schedulers.newThread())
        .subscribe(new Subscriber<Integer>() {

          @Override
          public void onStart() {
            request(1);
          }

          @Override
          public void onCompleted() {

          }

          @Override
          public void onError(Throwable throwable) {

          }

          @Override
          public void onNext(Integer integer) {
            Log.d(MainActivity.TAG, "<--------" + integer + "--------->");
            request(1);
          }
        });
  }

}
