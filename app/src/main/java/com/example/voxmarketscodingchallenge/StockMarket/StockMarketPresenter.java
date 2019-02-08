package com.example.voxmarketscodingchallenge.StockMarket;

import android.annotation.SuppressLint;
import android.util.Log;

import com.example.voxmarketscodingchallenge.base.BasePresenter;
import com.example.voxmarketscodingchallenge.model.Interactor.VoxApiServiceInteractor;
import com.example.voxmarketscodingchallenge.model.VoxResponse;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class StockMarketPresenter extends BasePresenter<StockMarketView> {

    String TAG = "Error Message";
    private List<VoxResponse> mResponseList;

    @Inject
    public StockMarketPresenter(VoxApiServiceInteractor mVoxApiServiceInteractor) {
        this.mVoxApiServiceInteractor = mVoxApiServiceInteractor;
    }


    /**
     * Method to get data from Api and pass the data to the view
     **/
    @SuppressLint("CheckResult")
    public void getListOfStockMarketExchanges() {

        getVoxApiServiceInteractor().getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<VoxResponse>>() {

                    @Override
                    public void accept(List<VoxResponse> voxResponses) throws Exception {

                        if (getMvpView() != null) {
                            try {
                                mResponseList = voxResponses;
                                getMvpView().onFetchDataSuccess(mResponseList);
                            } catch (Exception e) {
                                Log.i(TAG, e.getMessage());
                            }
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getMvpView().onFetchDataError(throwable.getMessage());
                    }
                });

        getMvpView().onFetchDataProgress();

    }

    /**
     * Sorting the List By Exchange Name
     **/
    protected void sortListByExchangeName() {
        for (int i = 0; i < mResponseList.size(); i++) {
            Collections.sort(mResponseList, VoxResponse.exchangeNameComparator);
            getMvpView().getAdapter().addVoxResponses(mResponseList);
        }
    }

    /**
     * Sorting the List By Date Created
     **/
    protected void sortListByCreatedAt() {
        for (int i = 0; i < mResponseList.size(); i++) {
            Collections.sort(mResponseList, VoxResponse.createdAtComparator);
            getMvpView().getAdapter().addVoxResponses(mResponseList);
        }
    }
}
