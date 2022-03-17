package com.huobi.domain.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Orderbook wrapper.
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderBookResponse {
    private String ch;
    private String status;
    private Long ts;
    private OrderBook tick;
}
