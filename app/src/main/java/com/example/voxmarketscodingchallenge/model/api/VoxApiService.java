package com.example.voxmarketscodingchallenge.model.api;

import com.example.voxmarketscodingchallenge.model.VoxResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

import static com.example.voxmarketscodingchallenge.model.api.ApiList.RELATIVE_URL;

public interface VoxApiService {
    @GET(RELATIVE_URL)
    Observable<List<VoxResponse>> getData();
}
