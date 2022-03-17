package com.huobi;

import com.huobi.domain.Response;
import com.huobi.domain.general.Asset;

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

}