package com.huobi.impl;

import com.huobi.HuobiApiRestClient;
import com.huobi.domain.Response;
import com.huobi.domain.general.Asset;

import java.util.List;

import static com.huobi.impl.HuobiApiServiceGenerator.executeSync;

/**
 * Implementation of Huobi's REST API using Retrofit with synchronous/blocking method calls.
 */
public class HuobiApiRestClientImpl implements HuobiApiRestClient {

    private final HuobiApiService huobiApiService;

    public HuobiApiRestClientImpl(HuobiApiService huobiApiService) {
        this.huobiApiService = huobiApiService;
    }

    // General endpoints

    @Override
    public Response<List<Asset>> getAssets() {
        return executeSync(huobiApiService.getAssets());
    }
}
