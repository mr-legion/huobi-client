package com.huobi.domain.general;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Asset status.
 */
public enum AssetStatus {
    @JsonProperty("normal")
    NORMAL,
    @JsonProperty("delisted")
    DELISTED
}
