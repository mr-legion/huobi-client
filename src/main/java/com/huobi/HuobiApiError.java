package com.huobi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/**
 * Huobi API error.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class HuobiApiError {

    @JsonProperty("ts")
    private Long timestamp;

    private String status;

    @JsonProperty("err-code")
    private String code;

    @JsonProperty("err-msg")
    private String msg;

}