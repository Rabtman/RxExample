package com.rabtman;

import android.app.Activity;
import android.os.Bundle;
import com.rabtman.backpressure.Part2;
import com.rabtman.example.R;

public class MainActivity extends Activity {

  public static final String TAG = "MainActivity";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    //关于背压
    Part2 part2 = new Part2();
    //part2.showRxBackpressureException();
    part2.showReactivePull();
  }

}
