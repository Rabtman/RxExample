package com.rabtman.throttling;

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
 * @author Rabtman 关于节流（Throttling）
 */

public class ThrottlingExample {

  //sample
  public void showSample() {
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
}
