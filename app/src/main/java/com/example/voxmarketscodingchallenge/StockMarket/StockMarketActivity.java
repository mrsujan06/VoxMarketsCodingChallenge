package com.example.voxmarketscodingchallenge.StockMarket;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.voxmarketscodingchallenge.App;
import com.example.voxmarketscodingchallenge.R;
import com.example.voxmarketscodingchallenge.base.BaseActivity;
import com.example.voxmarketscodingchallenge.model.VoxResponse;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StockMarketActivity extends BaseActivity implements StockMarketView {


    @Inject
    StockMarketPresenter mStockMarketPresenter;

    @BindView(R.id.data_list_rv)
    RecyclerView mRecyclerView;

    private StockMarketAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((App) getApplication()).getAppComponent().inject(this);

        ButterKnife.bind(this);

        mStockMarketPresenter.bind(this);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new StockMarketAdapter();

        getListOfStockMarketExchanges();

    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.stock_market_activity;
    }

    private void getListOfStockMarketExchanges() {
        mStockMarketPresenter.getListOfStockMarketExchanges();
    }

    @Override
    public void onFetchDataProgress() {
        showLoading();
    }

    @Override
    public void onFetchDataSuccess(List<VoxResponse> response) {
        mAdapter.addVoxResponses(response);
        mRecyclerView.setAdapter(mAdapter);
        hideLoading();
    }

    @Override
    public void onFetchDataError(String error) {
        Toast.makeText(this, "Error on StockMarketActivity", Toast.LENGTH_SHORT).show();
        hideLoading();
    }

    @Override
    public StockMarketAdapter getAdapter() {
        return mAdapter;
    }

    @OnClick(R.id.exchange_name_button)
    public void sortByExchangeNameButton() {
        mStockMarketPresenter.sortListByExchangeName();
        Toast.makeText(this, "Sorted By Exchange Name", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.created_at_button)
    public void sortByDateCreatedButton() {
        mStockMarketPresenter.sortListByCreatedAt();
        Toast.makeText(this, "Sorted By Date Created", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        mStockMarketPresenter.unbind();
        super.onDestroy();
    }


}
