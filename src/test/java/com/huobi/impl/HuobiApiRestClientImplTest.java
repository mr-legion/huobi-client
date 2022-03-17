package com.huobi.impl;

import com.huobi.HuobiApiClientFactory;
import com.huobi.HuobiApiRestClient;
import com.huobi.domain.Response;
import com.huobi.domain.general.Asset;
import com.huobi.domain.market.MarketInfo;
import com.huobi.domain.market.MarketTicker;
import com.huobi.domain.market.OrderBookResponse;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.huobi.constant.HuobiApiConstants.AGG_LEVEL_0;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class HuobiApiRestClientImplTest {

    private final HuobiApiRestClient huobiApiRestClient = HuobiApiClientFactory.newInstance().newRestClient();

    @Test
    public void getAssets_ShouldReturnAssets() {
        Response<List<Asset>> response = huobiApiRestClient.getAssets();
        assertNotNull(response);
        assertThat(response.getData(), is(not(empty())));
    }

    @Test
    public void getMarketInfo_ShouldReturnMarketInfo() {
        Response<List<MarketInfo>> response = huobiApiRestClient.getMarketInfo();
        assertNotNull(response);
        assertThat(response.getData(), is(not(empty())));
    }

    @Test
    public void getMarketTickers_ShouldReturnMarketTickers() {
        Response<List<MarketTicker>> response = huobiApiRestClient.getMarketTickers();
        assertNotNull(response);
        assertThat(response.getData(), is(not(empty())));
    }

    @Test
    public void getOrderBook_ShouldReturnOrderBookForBTCUSDT() {
        OrderBookResponse response = huobiApiRestClient.getOrderBook("btcusdt", 20, AGG_LEVEL_0);
        assertNotNull(response);
        assertThat(response.getTick().getAsks(), is(not(empty())));
        assertThat(response.getTick().getBids(), is(not(empty())));
    }
}