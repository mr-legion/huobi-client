package com.huobi.domain.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Market information.
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarketInfo {

    private String symbol;

    @JsonProperty("base-currency")
    private String baseAsset;

    @JsonProperty("quote-currency")
    private String quoteAsset;

    @JsonProperty("state")
    private MarketStatus status;

    @JsonProperty("symbol-partition")
    private String partition;

    @JsonProperty("price-precision")
    private Integer pricePrecision;

    @JsonProperty("amount-precision")
    private Integer amountPrecision;

    @JsonProperty("value-precision")
    private Integer valuePrecision;

    @JsonProperty("min-order-amt")
    private Double minOrderAmt;

    @JsonProperty("max-order-amt")
    private Double maxOrderAmt;

    @JsonProperty("min-order-value")
    private Double minOrderValue;

    @JsonProperty("limit-order-min-order-amt")
    private Double limitOrderMinOrderAmt;

    @JsonProperty("limit-order-max-order-amt")
    private Double limitOrderMaxOrderAmt;

    @JsonProperty("limit-order-max-buy-amt")
    private Double limitOrderMaxBuyAmt;

    @JsonProperty("limit-order-max-sell-amt")
    private Double limitOrderMaxSellAmt;

    @JsonProperty("buy-limit-must-less-than")
    private Double buyLimitMustLessThan;

    @JsonProperty("sell-limit-must-greater-than")
    private Double sellLimitMustGreaterThan;

    @JsonProperty("sell-market-min-order-amt")
    private Double sellMarketMinOrderAmt;

    @JsonProperty("sell-market-max-order-amt")
    private Double sellMarketMaxOrderAmt;

    @JsonProperty("buy-market-max-order-value")
    private Double buyMarketMaxOrderValue;

    @JsonProperty("market-sell-order-rate-must-less-than")
    private Double marketSellOrderRateMustLessThan;

    @JsonProperty("market-buy-order-rate-must-less-than")
    private Double marketBuyOrderRateMustLessThan;

    @JsonProperty("api-trading")
    private String apiTrading;

    @JsonProperty("tags")
    private String tags;

}
