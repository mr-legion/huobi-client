package com.huobi;

import com.huobi.domain.Response;
import com.huobi.domain.general.Asset;
import com.huobi.domain.market.MarketInfo;
import com.huobi.domain.market.MarketTicker;
import com.huobi.domain.market.OrderBookResponse;

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

    /**
     * Get market ticker information (asynchronous).
     *
     * @return market tickers
     */
    CompletableFuture<Response<List<MarketTicker>>> getMarketTickers();

    /**
     * Get orderbook for the market (asynchronous).
     *
     * @param market   market symbol (e.g. btcusdt)
     * @param limit    depth of the order book. Valid limits: [5, 10, 20].
     *                 When type is set to "step0", the default value of "depth" is 150 instead of 20.
     * @param aggLevel market depth aggregation level
     * @return orderbook
     */
    CompletableFuture<OrderBookResponse> getOrderBook(String market, Integer limit, String aggLevel);

}