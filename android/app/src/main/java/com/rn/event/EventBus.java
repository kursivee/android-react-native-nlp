package com.rn.event;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class EventBus extends ReactContextBaseJavaModule {
    private Map<String, Subscriber> subscriberMap = new HashMap<>();

    @Nonnull
    @Override
    public String getName() {
        return "EventBus";
    }

    public EventBus(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        subscriberMap.put("NAV_EVENT", EventSubscriber.getInstance());
    }

    @Nullable
    @Override
    public Map<String, Object> getConstants() {
        final Map<String, Object> constants =  new HashMap<>();
        constants.put("NAV_EVENT", "NAV_EVENT");
        constants.put("CONTENT_EVENT", "CONTENT_EVENT");
        return constants;
    }

    @ReactMethod
    public void publish(String eventType, String message) {
        subscriberMap.get(eventType).process(message);
    }
}
