package com.example.voxmarketscodingchallenge.model;

import com.google.gson.annotations.SerializedName;

import java.util.Comparator;

public class VoxResponse {

    @SerializedName("owner")
    private String owner;

    @SerializedName("createdAt")
    private String createdAt;

    @SerializedName("exchangeAvailable")
    private boolean exchangeAvailable;

    @SerializedName("updatedBy")
    private String updatedBy;

    @SerializedName("createdBy")
    private String createdBy;

    @SerializedName("exchangeFactSetCode")
    private String exchangeFactSetCode;

    @SerializedName("exchangeName")
    private String exchangeName;

    @SerializedName("exchangeMarketCode")
    private String exchangeMarketCode;

    @SerializedName("id")
    private String id;

    @SerializedName("exchangeCountryId")
    private String exchangeCountryId;

    @SerializedName("exchangeShortCode")
    private String exchangeShortCode;

    @SerializedName("updatedAt")
    private String updatedAt;

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setExchangeAvailable(boolean exchangeAvailable) {
        this.exchangeAvailable = exchangeAvailable;
    }

    public boolean isExchangeAvailable() {
        return exchangeAvailable;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setExchangeFactSetCode(String exchangeFactSetCode) {
        this.exchangeFactSetCode = exchangeFactSetCode;
    }

    public String getExchangeFactSetCode() {
        return exchangeFactSetCode;
    }

    public void setExchangeName(String exchangeName) {
        this.exchangeName = exchangeName;
    }

    public String getExchangeName() {
        return exchangeName;
    }

    public void setExchangeMarketCode(String exchangeMarketCode) {
        this.exchangeMarketCode = exchangeMarketCode;
    }

    public String getExchangeMarketCode() {
        return exchangeMarketCode;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setExchangeCountryId(String exchangeCountryId) {
        this.exchangeCountryId = exchangeCountryId;
    }

    public String getExchangeCountryId() {
        return exchangeCountryId;
    }

    public void setExchangeShortCode(String exchangeShortCode) {
        this.exchangeShortCode = exchangeShortCode;
    }

    public String getExchangeShortCode() {
        return exchangeShortCode;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

//    @Override
//    public int compareTo(Object o) {
//        return this.getExchangeName().compareTo(((VoxResponse) o).getExchangeName());
//    }
//

    /*Comparator for sorting the list by Exchange Name*/
    public static Comparator<VoxResponse> exchangeNameComparator = new Comparator<VoxResponse>() {
        @Override
        public int compare(VoxResponse voxResponse1, VoxResponse voxResponse2) {

            String exchangeName1 = voxResponse1.getExchangeName();
            String exchangeName2 = voxResponse2.getExchangeName();

            return exchangeName1.compareTo(exchangeName2);
        }

    };

    /*Comparator for sorting the list by createdAt*/
    public static Comparator<VoxResponse> createdAtComparator = new Comparator<VoxResponse>() {
        @Override
        public int compare(VoxResponse voxResponse1, VoxResponse voxResponse2) {

            String dateCreated1 = voxResponse1.getCreatedAt();
            String dateCreated2 = voxResponse2.getCreatedAt();

            return dateCreated1.compareTo(dateCreated2);
        }

    };


    @Override
    public String toString() {
        return
                "VoxResponse{" +
                        "owner = '" + owner + '\'' +
                        ",createdAt = '" + createdAt + '\'' +
                        ",exchangeAvailable = '" + exchangeAvailable + '\'' +
                        ",updatedBy = '" + updatedBy + '\'' +
                        ",createdBy = '" + createdBy + '\'' +
                        ",exchangeFactSetCode = '" + exchangeFactSetCode + '\'' +
                        ",exchangeName = '" + exchangeName + '\'' +
                        ",exchangeMarketCode = '" + exchangeMarketCode + '\'' +
                        ",id = '" + id + '\'' +
                        ",exchangeCountryId = '" + exchangeCountryId + '\'' +
                        ",exchangeShortCode = '" + exchangeShortCode + '\'' +
                        ",updatedAt = '" + updatedAt + '\'' +
                        "}";
    }


}