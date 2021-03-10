package com.shuhai.rocketmq.demo.utils;

public class IdGenerator {
    private static Sequence WORKER = new Sequence();

    public IdGenerator() {
    }

    public static long getId() {
        return WORKER.nextId();
    }

    public static String getIdStr() {
        return String.valueOf(WORKER.nextId());
    }
}