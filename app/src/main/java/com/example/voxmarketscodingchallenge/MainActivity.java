package com.example.voxmarketscodingchallenge;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.voxmarketscodingchallenge.base.BaseActivity;
import com.example.voxmarketscodingchallenge.model.VoxResponse;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements VoxMarketView {

    @BindView(R.id.data_list_rv)
    RecyclerView mRecyclerView;

    @Inject
    VoxPresenter mVoxPresenter;

    VoxAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((App) getApplication()).getAppComponent().inject(this);
        ButterKnife.bind(this);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        getListOfStockMarketExchanges();

    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_main;
    }

    private void getListOfStockMarketExchanges() {
        mVoxPresenter.getListOfStockMarketExchanges();
    }

    @Override
    public void onFetchDataProgress() {
        showLoading();
    }

    @Override
    public void onFetchDataSuccess(List<VoxResponse> response) {
        mAdapter = new VoxAdapter();
        mRecyclerView.setAdapter(mAdapter);
        hideLoading();
    }

    @Override
    public void onFetchDataError(String error) {
        Toast.makeText(this, "Error on MainActivity", Toast.LENGTH_SHORT).show();
        hideLoading();

    }


    @Override
    protected void onDestroy() {
        mVoxPresenter.unbind();
        super.onDestroy();
    }


}
