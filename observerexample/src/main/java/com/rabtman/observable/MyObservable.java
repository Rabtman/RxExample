package com.rabtman.observable;

import java.util.Observable;

/**
 * @author Rabtman
 */

public class MyObservable extends Observable {
    private String msg = "";

    public String getMsg() {
        return msg;
    }

    public void sendMsg(String str) {
        if (str != null && str.length() > 0) {
            this.msg = str;
            setChanged();    //发生变化
            notifyObservers();   //通知观察者
        }
    }
}
