package com.huobi.impl;

import com.huobi.HuobiApiRestClient;
import com.huobi.domain.Response;
import com.huobi.domain.general.Asset;
import com.huobi.domain.market.MarketInfo;
import com.huobi.domain.market.MarketTicker;
import com.huobi.domain.market.OrderBookResponse;

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

    // Market endpoints

    @Override
    public Response<List<MarketInfo>> getMarketInfo() {
        return executeSync(huobiApiService.getMarketInfo());
    }

    @Override
    public Response<List<MarketTicker>> getMarketTickers() {
        return executeSync(huobiApiService.getMarketTickers());
    }

    @Override
    public OrderBookResponse getOrderBook(String market, Integer limit, String aggLevel) {
        return executeSync(huobiApiService.getOrderBook(market, limit, aggLevel));
    }
}
