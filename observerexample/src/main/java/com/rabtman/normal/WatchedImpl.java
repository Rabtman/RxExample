package com.rabtman.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * author: Rabtman
 * date: 2017-02-21
 * description:
 */

public class WatchedImpl implements Watched {
    private List<Watcher> watchers = new ArrayList<Watcher>();

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
            watcher.update(str);
        }
    }
}
