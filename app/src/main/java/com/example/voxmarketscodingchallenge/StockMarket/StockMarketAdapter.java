package com.example.voxmarketscodingchallenge.StockMarket;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.voxmarketscodingchallenge.R;
import com.example.voxmarketscodingchallenge.model.VoxResponse;

import java.util.LinkedList;
import java.util.List;

public class StockMarketAdapter extends RecyclerView.Adapter<StockMarketAdapter.VoxAdapterViewHolder> {

    private List<VoxResponse> mVoxResponse = new LinkedList<>();

    @Override
    public VoxAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vox_market_view, parent, false);
        return new VoxAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VoxAdapterViewHolder voxAdapterViewHolder, int position) {
        voxAdapterViewHolder.doBinding(mVoxResponse.get(position));
    }

    @Override
    public int getItemCount() {
        return mVoxResponse.size();
    }

    void addVoxResponses(List<VoxResponse> Responses) {
        mVoxResponse.clear();
        mVoxResponse.addAll(Responses);
        notifyDataSetChanged();
    }


    class VoxAdapterViewHolder extends RecyclerView.ViewHolder {

        private TextView exchangeName;
        private TextView exchangeFactSetCode;
        private TextView createdAt;
        VoxResponse response;

        public VoxAdapterViewHolder(View itemView) {
            super(itemView);

            this.exchangeName = itemView.findViewById(R.id.textViewExchangeName);
            this.exchangeFactSetCode = itemView.findViewById(R.id.textViewExchangeFactSetCode);
            this.createdAt = itemView.findViewById(R.id.textViewCreatedAt);
        }

        void doBinding(VoxResponse response) {
            this.response = response;
            this.exchangeName.setText(response.getExchangeName());
            this.exchangeFactSetCode.setText(response.getExchangeFactSetCode());
            this.createdAt.setText(response.getCreatedAt());
        }

    }
}
