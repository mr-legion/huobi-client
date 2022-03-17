package com.huobi;

import com.huobi.domain.Response;
import com.huobi.domain.general.Asset;
import com.huobi.domain.market.MarketInfo;

import java.util.List;

/**
 * Huobi API facade, supporting synchronous/blocking access Huobi's REST API.
 */
public interface HuobiApiRestClient {

    // General endpoints

    /**
     * Get all supported assets.
     *
     * @return assets
     */
    Response<List<Asset>> getAssets();

    // Market endpoints

    /**
     * Get all supported markets.
     *
     * @return market info
     */
    Response<List<MarketInfo>> getMarketInfo();

}