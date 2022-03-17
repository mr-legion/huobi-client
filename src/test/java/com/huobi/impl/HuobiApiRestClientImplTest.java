package com.huobi.impl;

import com.huobi.HuobiApiClientFactory;
import com.huobi.HuobiApiRestClient;
import com.huobi.domain.Response;
import com.huobi.domain.general.Asset;
import org.junit.jupiter.api.Test;

import java.util.List;

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
}