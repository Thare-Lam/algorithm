package com.thare.algorithm.archive.base.singleton.hungry;

public class Singleton {

    private final static Singleton instance = new Singleton();

    private Singleton() {}

    public static Singleton getInstance() {
        return instance;
    }

}

