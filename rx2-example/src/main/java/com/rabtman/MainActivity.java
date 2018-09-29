package com.rabtman;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import com.rabtman.backpressure.BackpressureExample;
import com.rabtman.example.R;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainActivity extends Activity {

  public static final String TAG = "MainActivity";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    //normal use
    Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
      @Override
      public void subscribe(ObservableEmitter<String> e) throws Exception {
        e.onNext("onNext");
        e.onComplete();
      }
    });
    Observer observer = new Observer<String>() {
      @Override
      public void onSubscribe(Disposable d) {
        Log.d(TAG, "onSubscribe:" + d.isDisposed());
      }

      @Override
      public void onNext(String o) {
        Log.d(TAG, "onNext:" + o);
      }

      @Override
      public void onError(Throwable e) {
        Log.d(TAG, "onError:" + e.getMessage());
      }

      @Override
      public void onComplete() {
        Log.d(TAG, "onComplete:");
      }
    };
    observable.subscribe(observer);

    //关于背压
    BackpressureExample backpressureExample = new BackpressureExample();
    //backpressureExample.showRxBackpressureException();
    //backpressureExample.showBackpressureStrategyBuffer();
    //backpressureExample.showBackpressureStrategyDrop();
    //backpressureExample.showBackpressureStrategyLatest();
    //backpressureExample.showReactivePull();
  }

}
