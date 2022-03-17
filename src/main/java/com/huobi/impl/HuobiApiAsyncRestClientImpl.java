package com.huobi.impl;

import com.huobi.HuobiApiAsyncRestClient;
import com.huobi.domain.Response;
import com.huobi.domain.general.Asset;
import com.huobi.domain.market.MarketInfo;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Implementation of Huobi's REST API using Retrofit with asynchronous/non-blocking method calls.
 */
public class HuobiApiAsyncRestClientImpl implements HuobiApiAsyncRestClient {

    private final HuobiApiService huobiApiService;

    public HuobiApiAsyncRestClientImpl(HuobiApiService huobiApiService) {
        this.huobiApiService = huobiApiService;
    }

    // General endpoints

    @Override
    public CompletableFuture<Response<List<Asset>>> getAssets() {
        CompletableFuture<Response<List<Asset>>> future = new CompletableFuture<>();
        huobiApiService.getAssets().enqueue(new RetrofitCallbackAdapter<>(future));
        return future;
    }

    // Market endpoints

    @Override
    public CompletableFuture<Response<List<MarketInfo>>> getMarketInfo() {
        CompletableFuture<Response<List<MarketInfo>>> future = new CompletableFuture<>();
        huobiApiService.getMarketInfo().enqueue(new RetrofitCallbackAdapter<>(future));
        return future;
    }
}