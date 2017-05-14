package com.rabtman.normal;

/**
 * author: Rabtman
 * date: 2017-02-21
 * description:
 */

public interface Watched {
    void addWatcher(Watcher watcher);

    void removeWatcher(Watcher watcher);

    void notifyWatchers(String str);
}
