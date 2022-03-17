package com.huobi.domain.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Market status.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum MarketStatus {
    /**
     * To be online soon.
     */
    @JsonProperty("pre-online")
    PRE_ONLINE,

    /**
     * Listed, available for trading.
     */
    @JsonProperty("online")
    ONLINE,

    /**
     * De-listed, not available for trading.
     */
    @JsonProperty("offline")
    OFFLINE,

    /**
     * Suspended for trading.
     */
    @JsonProperty("suspend")
    SUSPEND
}
