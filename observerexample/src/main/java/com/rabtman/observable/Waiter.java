package com.rabtman.observable;

import java.util.Observable;
import java.util.Observer;

/**
 * @author Rabtman
 */

public class Waiter implements Observer {

    private String name;

    public Waiter(String name, Customer observable) {
        this.name = name;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Waiter-" + name + ": " + ((Customer) o).getOrder());
    }
}
