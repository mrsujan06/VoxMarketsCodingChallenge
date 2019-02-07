package com.example.voxmarketscodingchallenge;

import com.example.voxmarketscodingchallenge.base.MvpView;
import com.example.voxmarketscodingchallenge.model.VoxResponse;

import java.util.List;

public interface VoxMarketView extends MvpView {

    void onFetchDataProgress();

    void onFetchDataSuccess(List<VoxResponse> response);

    void onFetchDataError(String error);

}
