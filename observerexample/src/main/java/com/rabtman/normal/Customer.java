package com.rabtman.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * author: Rabtman
 * date: 2017-02-21
 * description:
 */

public class Customer implements Watched {
    private String name;
    private List<Watcher> watchers = new ArrayList<Watcher>();

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public void addWatcher(Watcher watcher) {
        watchers.add(watcher);
    }

    @Override
    public void removeWatcher(Watcher watcher) {
        watchers.remove(watcher);
    }

    @Override
    public void notifyWatchers(String str) {
        for (Watcher watcher : watchers) {
            watcher.update("Customer-" + name + "-" + str);
        }
    }
}
