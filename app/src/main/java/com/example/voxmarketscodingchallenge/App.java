package com.example.voxmarketscodingchallenge;

import android.app.Application;

import com.example.voxmarketscodingchallenge.dagger2.AppComponent;
import com.example.voxmarketscodingchallenge.dagger2.DaggerAppComponent;

public class App extends Application {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.create();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

}
