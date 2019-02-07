package com.example.voxmarketscodingchallenge.dagger2;

import com.example.voxmarketscodingchallenge.MainActivity;

import dagger.Component;

@Component(modules = {StockModule.class})
public interface AppComponent {
    void inject(MainActivity activity);
}
