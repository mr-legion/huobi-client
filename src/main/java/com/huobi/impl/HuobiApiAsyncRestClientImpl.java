package com.huobi.impl;

import com.huobi.HuobiApiAsyncRestClient;
import com.huobi.domain.Response;
import com.huobi.domain.general.Asset;

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
}
