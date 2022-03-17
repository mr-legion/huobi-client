package com.huobi.domain.general;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import static com.huobi.domain.general.TransactionStatus.ALLOWED;
import static com.huobi.domain.general.WithdrawFeeType.FIXED;

/**
 * Asset information.
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Asset {

    @JsonProperty("currency")
    private String symbol;

    @JsonProperty("instStatus")
    private AssetStatus status;

    @JsonProperty("chains")
    private List<Network> networks;

    public boolean isDepositEnabled() {
        return networks.stream().anyMatch(network -> network.getDepositStatus() == ALLOWED);
    }

    public boolean isWithdrawEnabled() {
        return networks.stream().anyMatch(network -> network.getWithdrawStatus() == ALLOWED);
    }

    public Integer getMinConfirm() {

        Integer minConfirm = null;

        for (Network network : networks) {
            Integer confirm = network.getMinConfirm();
            if (minConfirm == null || (confirm != null && confirm < minConfirm)) {
                minConfirm = confirm;
            }
        }

        return minConfirm;
    }

    public Integer getMinUnLockConfirm() {

        Integer minConfirm = null;

        for (Network network : networks) {
            Integer confirm = network.getUnLockConfirm();
            if (minConfirm == null || (confirm != null && confirm < minConfirm)) {
                minConfirm = confirm;
            }
        }

        return minConfirm;
    }

    public Double getMinFixedWithdrawFee() {

        Double minFee = null;

        for (Network network : networks) {
            if (network.getWithdrawFeeType() == FIXED) {
                Double fee = network.getWithdrawFee();
                if (minFee == null || (fee != null && fee < minFee)) {
                    minFee = fee;
                }
            }
        }

        return minFee;
    }
}