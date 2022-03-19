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
        this.serviceGenerator = new HuobiApiServiceGenerator(new OkHttpClient());
    }

    public HuobiApiClientFactory(ApiInteractionConfig apiInteractionConfig) {
        this(new OkHttpClient(), apiInteractionConfig);
    }

    public HuobiApiClientFactory(OkHttpClient client, ApiInteractionConfig apiInteractionConfig) {
        OkHttpClient newClient = client.newBuilder()
                .proxySelector(new CustomProxySelector(apiInteractionConfig.getProxies()))
                .addInterceptor(new RateLimitInterceptor(
                        apiInteractionConfig.getMaxRequestsPerSecond(),
                        apiInteractionConfig.getMaxApiKeyUsagePerSecond()
                )).build();
        this.serviceGenerator = new HuobiApiServiceGenerator(newClient);
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
