package com.huobi.impl;

import com.huobi.HuobiApiError;
import com.huobi.exception.HuobiApiException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

import static com.huobi.impl.HuobiApiServiceGenerator.getHuobiApiError;

/**
 * An adapter/wrapper that transform a response to the {@link CompletableFuture}.
 */
public class RetrofitCallbackAdapter<T> implements Callback<T> {

    private final CompletableFuture<T> future;

    public RetrofitCallbackAdapter(CompletableFuture<T> future) {
        this.future = future;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            future.complete(response.body());
        } else {
            try {
                HuobiApiError apiError = getHuobiApiError(response);
                onFailure(call, new HuobiApiException(apiError));
            } catch (IOException e) {
                onFailure(call, new HuobiApiException(e));
            }
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        if (t instanceof HuobiApiException) {
            future.completeExceptionally(t);
        } else {
            future.completeExceptionally(new HuobiApiException(t));
        }
    }
}
