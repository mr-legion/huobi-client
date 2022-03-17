package com.huobi;

import com.huobi.impl.HuobiApiAsyncRestClientImpl;
import com.huobi.impl.HuobiApiRestClientImpl;
import com.huobi.impl.HuobiApiService;
import com.huobi.impl.HuobiApiServiceGenerator;
import okhttp3.OkHttpClient;

/**
 * A factory for creating Huobi API client objects.
 */
public class HuobiApiClientFactory {

    private final HuobiApiServiceGenerator serviceGenerator;

    public HuobiApiClientFactory() {
        this(new OkHttpClient());
    }

    private HuobiApiClientFactory(OkHttpClient client) {
        this.serviceGenerator = new HuobiApiServiceGenerator(client);
    }

    /**
     * New instance without authentication.
     *
     * @return the Huobi API client factory
     */
    public static HuobiApiClientFactory newInstance() {
        return new HuobiApiClientFactory();
    }

    /**
     * Creates a new synchronous/blocking REST client.
     */
    public HuobiApiRestClient newRestClient() {
        return new HuobiApiRestClientImpl(serviceGenerator.createService(HuobiApiService.class));
    }

    /**
     * Creates a new asynchronous/non-blocking REST client.
     */
    public HuobiApiAsyncRestClient newAsyncRestClient() {
        return new HuobiApiAsyncRestClientImpl(serviceGenerator.createService(HuobiApiService.class));
    }
}
