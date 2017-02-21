package com.rabtman;

import com.rabtman.normal.Watched;
import com.rabtman.normal.WatchedImpl;
import com.rabtman.normal.Watcher;
import com.rabtman.normal.WatcherImpl;

public class ObserverExample {
    public static void main(String[] var0) {
        //普通版观察者模式
        Watched someone = new WatchedImpl();
        Watcher A = new WatcherImpl();
        Watcher B = new WatcherImpl();

        someone.addWatcher(A);
        someone.addWatcher(B);

        someone.notifyWatchers("help!!!");
    }
}
