package com.example.voxmarketscodingchallenge;

import android.annotation.SuppressLint;
import android.util.Log;
import android.widget.Toast;

import com.example.voxmarketscodingchallenge.base.BasePresenter;
import com.example.voxmarketscodingchallenge.model.Interactor.VoxApiServiceInteractor;
import com.example.voxmarketscodingchallenge.model.VoxResponse;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class VoxPresenter extends BasePresenter<VoxMarketView> {

    VoxAdapter mVoxAdapter;

    @Inject
    public VoxPresenter(VoxApiServiceInteractor mVoxApiServiceInteractor) {
        this.mVoxApiServiceInteractor = mVoxApiServiceInteractor;
    }

    /**
     * Methods
     ***/
    @SuppressLint("CheckResult")
    public void getListOfStockMarketExchanges() {

        getVoxApiServiceInteractor().getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<VoxResponse>>() {

                    @Override
                    public void accept(List<VoxResponse> voxResponses) throws Exception {
                        getMvpView().onFetchDataSuccess(voxResponses);

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                    //    getMvpView().onFetchDataError(throwable.getMessage());
                    }
                });

    }
}
