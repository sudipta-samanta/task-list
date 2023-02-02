package com.codurance.training.tasks.utils;

public class IDGenerator {
    private long lastId = 0;
    public long nextID() {
        return ++lastId;
    }
}
