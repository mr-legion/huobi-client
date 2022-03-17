package com.huobi.domain.general;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Network information.
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Network {

    @JsonProperty("chain")
    private String name;
    private String displayName;
    private String fullName;

    @JsonProperty("depositStatus")
    private TransactionStatus depositStatus;

    @JsonProperty("withdrawStatus")
    private TransactionStatus withdrawStatus;

    /**
     * Number of confirmations required for quick success
     * (trading allowed but withdrawal disallowed once reached).
     */
    @JsonProperty("numOfFastConfirmations")
    private Integer minConfirm;

    /**
     * Number of confirmations required for deposit success
     * (trading & withdrawal allowed once reached).
     */
    @JsonProperty("numOfConfirmations")
    private Integer unLockConfirm;

    /**
     * Is dynamic fee type or not (only applicable to withdrawFeeType = fixed).
     */
    @JsonProperty("isDynamic")
    private Boolean dynamicFee;

    private WithdrawFeeType withdrawFeeType;

    /**
     * Only applicable to withdrawFeeType = fixed.
     */
    @JsonProperty("transactFeeWithdraw")
    private Double withdrawFee;

    /**
     * Only applicable to withdrawFeeType = circulated or ratio.
     */
    @JsonProperty("minTransactFeeWithdraw")
    private Double minWithdrawFee;

    /**
     * Only applicable to withdrawFeeType = circulated or ratio.
     */
    @JsonProperty("maxTransactFeeWithdraw")
    private Double maxWithdrawFee;

    private Double minDepositAmt;
    private Double minWithdrawAmt;
    private Double maxWithdrawAmt;

    private Integer withdrawPrecision;

    private Double withdrawQuotaPerDay;
    private Double withdrawQuotaPerYear;
    private Double withdrawQuotaTotal;

    private Boolean addrWithTag;
    private Boolean addrDepositTag;

}
