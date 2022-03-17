package com.huobi;

import com.huobi.domain.Response;
import com.huobi.domain.general.Asset;
import com.huobi.domain.market.MarketInfo;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Huobi API facade, supporting asynchronous/non-blocking access Huobi's REST API.
 */
public interface HuobiApiAsyncRestClient {

    // General endpoints

    /**
     * Get all supported assets (asynchronous).
     *
     * @return assets
     */
    CompletableFuture<Response<List<Asset>>> getAssets();

    // Market endpoints

    /**
     * Get all supported markets (asynchronous).
     *
     * @return market info
     */
    CompletableFuture<Response<List<MarketInfo>>> getMarketInfo();

}