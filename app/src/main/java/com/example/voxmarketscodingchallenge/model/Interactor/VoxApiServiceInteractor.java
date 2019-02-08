package com.example.voxmarketscodingchallenge.model.Interactor;

import com.example.voxmarketscodingchallenge.model.VoxResponse;

import java.util.List;

import io.reactivex.Observable;

public interface VoxApiServiceInteractor {

    Observable<List<VoxResponse>> getData();
}
