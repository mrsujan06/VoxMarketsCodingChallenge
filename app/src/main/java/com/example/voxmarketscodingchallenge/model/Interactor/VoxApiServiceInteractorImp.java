package com.example.voxmarketscodingchallenge.model.Interactor;

import com.example.voxmarketscodingchallenge.model.VoxResponse;
import com.example.voxmarketscodingchallenge.model.api.VoxApiService;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.voxmarketscodingchallenge.model.api.ApiList.BASE_URL;

public class VoxApiServiceInteractorImp implements VoxApiServiceInteractor {

    private VoxApiService mVoxApiService;

    public VoxApiServiceInteractorImp() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mVoxApiService = retrofit.create(VoxApiService.class);

    }

    @Override
    public Observable<List<VoxResponse>> getData() {
        return mVoxApiService.getData();
    }
}
