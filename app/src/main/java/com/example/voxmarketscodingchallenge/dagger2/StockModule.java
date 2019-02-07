package com.example.voxmarketscodingchallenge.dagger2;

import com.example.voxmarketscodingchallenge.model.Interactor.VoxApiServiceInteractor;
import com.example.voxmarketscodingchallenge.model.Interactor.VoxApiServiceInteractorImp;

import dagger.Module;
import dagger.Provides;

@Module
public class StockModule {

    @Provides
    public VoxApiServiceInteractor getVoxApiServiceInteractor(){
        return new VoxApiServiceInteractorImp();
    }
}
