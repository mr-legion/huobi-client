package com.huobi.domain.general;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Withdraw fee type.
 */
public enum WithdrawFeeType {
    @JsonProperty("fixed")
    FIXED,
    @JsonProperty("circulated")
    CIRCULATED,
    @JsonProperty("ratio")
    RATIO
}
