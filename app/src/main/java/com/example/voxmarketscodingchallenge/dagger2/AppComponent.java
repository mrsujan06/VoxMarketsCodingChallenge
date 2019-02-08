package com.example.voxmarketscodingchallenge.dagger2;

import com.example.voxmarketscodingchallenge.StockMarket.StockMarketActivity;

import dagger.Component;

@Component(modules = {StockModule.class})
public interface AppComponent {
    void inject(StockMarketActivity activity);
}
