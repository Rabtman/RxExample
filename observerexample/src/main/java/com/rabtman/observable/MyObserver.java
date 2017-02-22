package com.rabtman.observable;

import java.util.Observable;
import java.util.Observer;

/**
 * @author Rabtman
 */

public class MyObserver implements Observer {

    public MyObserver(MyObservable observable) {
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(((MyObservable) o).getMsg());
    }
}
