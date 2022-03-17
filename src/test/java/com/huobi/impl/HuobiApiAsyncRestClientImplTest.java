package com.huobi.impl;

import com.huobi.HuobiApiAsyncRestClient;
import com.huobi.HuobiApiClientFactory;
import com.huobi.domain.Response;
import com.huobi.domain.general.Asset;
import com.huobi.domain.market.MarketInfo;
import com.huobi.domain.market.MarketTicker;
import com.huobi.domain.market.OrderBookResponse;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.ExecutionException;

import static com.huobi.constant.HuobiApiConstants.AGG_LEVEL_0;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class HuobiApiAsyncRestClientImplTest {

    private final HuobiApiAsyncRestClient huobiApiAsyncRestClient = HuobiApiClientFactory.newInstance().newAsyncRestClient();

    @Test
    public void getAssets_ShouldReturnAssets() throws ExecutionException, InterruptedException {
        Response<List<Asset>> response = huobiApiAsyncRestClient.getAssets().get();
        assertNotNull(response);
        assertThat(response.getData(), is(not(empty())));
    }

    @Test
    public void getMarketInfo_ShouldReturnMarketInfo() throws ExecutionException, InterruptedException {
        Response<List<MarketInfo>> response = huobiApiAsyncRestClient.getMarketInfo().get();
        assertNotNull(response);
        assertThat(response.getData(), is(not(empty())));
    }

    @Test
    public void getMarketTickers_ShouldReturnMarketTickers() throws ExecutionException, InterruptedException {
        Response<List<MarketTicker>> response = huobiApiAsyncRestClient.getMarketTickers().get();
        assertNotNull(response);
        assertThat(response.getData(), is(not(empty())));
    }

    @Test
    public void getOrderBook_ShouldReturnOrderBookForBTCUSDT() throws ExecutionException, InterruptedException {
        OrderBookResponse response = huobiApiAsyncRestClient.getOrderBook("btcusdt", 20, AGG_LEVEL_0).get();
        assertNotNull(response);
        assertThat(response.getTick().getAsks(), is(not(empty())));
        assertThat(response.getTick().getBids(), is(not(empty())));
    }
}