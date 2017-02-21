package com.rabtman.normal;

/**
 * author: Rabtman
 * date: 2017-02-21
 * description:
 */

public class WatcherImpl implements Watcher {
    @Override
    public void update(String str) {
        System.out.println(str);
    }
}
