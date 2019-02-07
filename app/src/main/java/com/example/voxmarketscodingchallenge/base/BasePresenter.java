package com.example.voxmarketscodingchallenge.base;

import com.example.voxmarketscodingchallenge.model.Interactor.VoxApiServiceInteractor;

public class BasePresenter <V extends MvpView>{

    protected VoxApiServiceInteractor mVoxApiServiceInteractor;

    private V mMvpView;

    public void bind(V view) {
        this.mMvpView = view;
    }

    public void unbind() {
        mMvpView = null;
    }

    public V getMvpView() {
        return mMvpView;
    }

    public VoxApiServiceInteractor getVoxApiServiceInteractor(){
        return mVoxApiServiceInteractor;
    }



}
