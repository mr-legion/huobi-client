package com.huobi.domain.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Market ticker information.
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarketTicker {

    private String symbol;

    private Double open;
    private Double close;

    private Double low;
    private Double high;

    private Double ask;
    private Double bid;

    private Double askSize;
    private Double bidSize;

    private Double amount;
    private Double vol;
    private Double count;

}
