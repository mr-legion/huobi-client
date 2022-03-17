package com.huobi.domain.general;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Asset status.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum AssetStatus {
    @JsonProperty("normal")
    NORMAL,
    @JsonProperty("delisted")
    DELISTED
}
