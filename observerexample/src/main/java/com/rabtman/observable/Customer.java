package com.rabtman.observable;

import java.util.Observable;

/**
 * @author Rabtman
 */

public class Customer extends Observable {
    private String name;
    private String order = "";

    public Customer(String name) {
        this.name = name;
    }

    public String getOrder() {
        return order;
    }

    public void call(String str) {
        if (str != null && str.length() > 0) {
            this.order = "Customer-" + name + "-" + str;
            setChanged();    //发生变化
            notifyObservers();   //通知观察者
        }
    }
}
