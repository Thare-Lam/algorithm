package com.thare.algorithm.archive.base.singleton.lazy;

public class Singleton {

    private static Singleton instance;

    private Singleton() {}

    private synchronized static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

}
