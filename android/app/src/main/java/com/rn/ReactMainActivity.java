package com.rn;

import android.os.Bundle;

import com.facebook.react.ReactActivity;

import javax.annotation.Nullable;

public class ReactMainActivity extends ReactActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    protected String getMainComponentName() {
        return "rn";
    }
}
