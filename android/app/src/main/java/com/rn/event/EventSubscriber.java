package com.rn.event;

public class EventSubscriber implements Subscriber<String> {
    private static EventSubscriber instance = null;

    private EventSubscriber() {}

    public static EventSubscriber getInstance() {
        if(instance == null) {
            instance = new EventSubscriber();
        }
        return instance;
    }

    private Callback<String> callback;

    @Override
    public void setCallback(Callback<String> callback) {
        this.callback = callback;
    }

    @Override
    public void process(String message) {
        callback.run(message);
    }
}
