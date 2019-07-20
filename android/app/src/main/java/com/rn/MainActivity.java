package com.rn;

import android.os.Bundle;

import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.rn.event.EventSubscriber;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventSubscriber.getInstance().setCallback((String message) -> {
                    Snackbar.make(view, "YES", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    ((TextView) findViewById(R.id.tv_message)).setText(message);
                });
                ((MainApplication) getApplication()).getReactNativeHost().getReactInstanceManager().getCurrentReactContext()
                        .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                        .emit("what", null);
            }
        });
    }

}
