package com.huobi.constant;

import lombok.experimental.UtilityClass;

/**
 * Constants used throughout Huobi's API.
 */
@UtilityClass
public class HuobiApiConstants {

    /**
     * Base domain.
     */
    public static final String BASE_DOMAIN = "huobi.pro";

    /**
     * REST API base URL.
     */
    public static final String API_BASE_URL = "https://api-aws." + BASE_DOMAIN;

    // Market depth aggregation level
    public static final String AGG_LEVEL_0 = "step0";
    public static final String AGG_LEVEL_1 = "step1";
    public static final String AGG_LEVEL_2 = "step2";
    public static final String AGG_LEVEL_3 = "step3";
    public static final String AGG_LEVEL_4 = "step4";
    public static final String AGG_LEVEL_5 = "step5";
}