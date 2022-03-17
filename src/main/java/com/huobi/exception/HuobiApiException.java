package com.huobi.exception;

import com.huobi.HuobiApiError;

/**
 * An exception which can occur while invoking methods of the Huobi API.
 */
public class HuobiApiException extends RuntimeException {

    private static final long serialVersionUID = 8280463674117834117L;

    private HuobiApiError error;

    public HuobiApiException(HuobiApiError error) {
        this.error = error;
    }

    public HuobiApiException() {
        super();
    }

    public HuobiApiException(String message) {
        super(message);
    }

    public HuobiApiException(Throwable cause) {
        super(cause);
    }

    public HuobiApiException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @return the response error object from Huobi API,
     * or null if no response object was returned (e.g. server returned 500).
     */
    public HuobiApiError getError() {
        return error;
    }

    @Override
    public String getMessage() {
        if (error != null) {
            return error.getMsg();
        }
        return super.getMessage();
    }
}
