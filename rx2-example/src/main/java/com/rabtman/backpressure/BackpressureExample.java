package com.rabtman.backpressure;

import android.os.SystemClock;
import android.util.Log;
import com.rabtman.MainActivity;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @author Rabtman 关于背压
 */

public class BackpressureExample {

  //BackpressureStrategyBuffer
  public void showBackpressureStrategyBuffer() {
    Flowable.create(new FlowableOnSubscribe<Integer>() {
      @Override
      public void subscribe(@NonNull FlowableEmitter<Integer> emitter) throws Exception {
        for (int i = 0; ; i++) {
          emitter.onNext(i);
        }
      }
    }, BackpressureStrategy.BUFFER)
        .observeOn(Schedulers.newThread())
        .subscribe(new Consumer<Integer>() {
          @Override
          public void accept(@NonNull Integer integer) throws Exception {
            SystemClock.sleep(100);
            Log.d(MainActivity.TAG, "<--------" + integer + "--------->");
          }
        });
  }

  //BackpressureStrategyLatest
  public void showBackpressureStrategyLatest() {
    Flowable.create(new FlowableOnSubscribe<Integer>() {
      @Override
      public void subscribe(@NonNull FlowableEmitter<Integer> emitter) throws Exception {
        for (int i = 0; ; i++) {
          emitter.onNext(i);
        }
      }
    }, BackpressureStrategy.LATEST)
        .observeOn(Schedulers.newThread())
        .subscribe(new Consumer<Integer>() {
          @Override
          public void accept(@NonNull Integer integer) throws Exception {
            SystemClock.sleep(100);
            Log.d(MainActivity.TAG, "<--------" + integer + "--------->");
          }
        });
  }

  //BackpressureStrategyDrop
  public void showBackpressureStrategyDrop() {
    Flowable.create(new FlowableOnSubscribe<Integer>() {
      @Override
      public void subscribe(@NonNull FlowableEmitter<Integer> emitter) throws Exception {
        for (int i = 0; ; i++) {
          emitter.onNext(i);
        }
      }
    }, BackpressureStrategy.DROP)
        .observeOn(Schedulers.newThread())
        .subscribe(new Consumer<Integer>() {
          @Override
          public void accept(@NonNull Integer integer) throws Exception {
            SystemClock.sleep(100);
            Log.d(MainActivity.TAG, "<--------" + integer + "--------->");
          }
        });
  }

}
