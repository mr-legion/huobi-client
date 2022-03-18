package com.huobi.impl;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.huobi.HuobiApiError;
import com.huobi.exception.HuobiApiException;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.lang.annotation.Annotation;

import static com.huobi.constant.HuobiApiConstants.API_BASE_URL;

/**
 * Generates a Huobi API implementation based on @see {@link HuobiApiService}.
 */
public class HuobiApiServiceGenerator {

    private static final ObjectMapper mapper = new ObjectMapper();
    private static final Converter.Factory converterFactory = JacksonConverterFactory.create(mapper);
    @SuppressWarnings("unchecked")
    private static final Converter<ResponseBody, HuobiApiError> errorBodyConverter =
            (Converter<ResponseBody, HuobiApiError>) converterFactory.responseBodyConverter(
                    HuobiApiError.class, new Annotation[0], null);

    static {
        mapper.enable(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL);
    }

    private final OkHttpClient client;

    public HuobiApiServiceGenerator(OkHttpClient client) {
        this.client = client;
    }

    public <S> S createService(Class<S> serviceClass) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(converterFactory)
                .client(client)
                .build();

        return retrofit.create(serviceClass);
    }

    /**
     * Execute a REST call and block until the response is received.
     */
    public static <T> T executeSync(Call<T> call) {
        try {
            Response<T> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                HuobiApiError apiError = getHuobiApiError(response);
                throw new HuobiApiException(apiError);
            }
        } catch (IOException e) {
            throw new HuobiApiException(e);
        }
    }

    /**
     * Extracts and converts the response error body into an object.
     */
    public static HuobiApiError getHuobiApiError(Response<?> response) throws IOException, HuobiApiException {
        return errorBodyConverter.convert(response.errorBody());
    }
}
