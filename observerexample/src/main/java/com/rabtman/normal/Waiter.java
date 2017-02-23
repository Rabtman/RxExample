package com.rabtman.normal;

/**
 * author: Rabtman
 * date: 2017-02-21
 * description:
 */

public class Waiter implements Watcher {

    private String name;

    public Waiter(String name) {
        this.name = name;
    }

    @Override
    public void update(String str) {
        System.out.println("Waiter-" + name + ": " + str);
    }
}
