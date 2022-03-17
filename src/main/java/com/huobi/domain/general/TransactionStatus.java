package com.huobi.domain.general;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Transaction status.
 */
public enum TransactionStatus {
    @JsonProperty("allowed")
    ALLOWED,
    @JsonProperty("prohibited")
    PROHIBITED
}
