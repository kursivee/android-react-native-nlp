package com.rn.event;

public interface Callback<T> {
    void run(T message);
}
