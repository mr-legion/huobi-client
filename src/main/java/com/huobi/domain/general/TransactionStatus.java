package com.huobi.domain.general;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Transaction status.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum TransactionStatus {
    @JsonProperty("allowed")
    ALLOWED,
    @JsonProperty("prohibited")
    PROHIBITED
}
