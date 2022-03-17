package com.huobi.impl;

import com.huobi.domain.Response;
import com.huobi.domain.general.Asset;
import com.huobi.domain.market.MarketInfo;
import com.huobi.domain.market.MarketTicker;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

/**
 * Huobi's REST API URL mappings.
 */
public interface HuobiApiService {

    // General endpoints

    @GET("/v2/reference/currencies")
    Call<Response<List<Asset>>> getAssets();

    // Market endpoints

    @GET("/v1/common/symbols")
    Call<Response<List<MarketInfo>>> getMarketInfo();

    @GET("/market/tickers")
    Call<Response<List<MarketTicker>>> getMarketTickers();

}
