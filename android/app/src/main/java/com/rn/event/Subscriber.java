package com.rn.event;

public interface Subscriber<T> {
    void setCallback(Callback<T> callback);
    void process(String message);
}
