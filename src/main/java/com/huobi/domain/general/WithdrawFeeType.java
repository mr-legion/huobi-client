package com.huobi.domain.general;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Withdraw fee type.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum WithdrawFeeType {
    @JsonProperty("fixed")
    FIXED,
    @JsonProperty("circulated")
    CIRCULATED,
    @JsonProperty("ratio")
    RATIO
}
