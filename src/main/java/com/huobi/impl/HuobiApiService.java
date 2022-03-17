package com.huobi.impl;

import com.huobi.domain.Response;
import com.huobi.domain.general.Asset;
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

}
