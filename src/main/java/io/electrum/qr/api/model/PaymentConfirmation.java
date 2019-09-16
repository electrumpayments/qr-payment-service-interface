package io.electrum.qr.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.electrum.vas.Utils;
import io.electrum.vas.model.BasicAdvice;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * Confirm that a previous {@link PaymentRequest} has completed successfully at the POS.
 **/

@ApiModel(description = "Confirm that a previous {@link PaymentRequest} has completed successfully at the POS.")
public class PaymentConfirmation extends BasicAdvice {
    protected String tranId = null;

    /**
     * The unique transaction identifier related to this transaction. This transaction identifier was encoded within the
     * QR Code and used to associate the scan and the payment request.
     **/
    public PaymentConfirmation tranId(String tranId) {
        this.tranId = tranId;
        return this;
    }

    @ApiModelProperty(required = false, value = "The unique transaction identifier related to this transaction. This "
            + "transaction identifier was encoded within the QR Code and used to associate the scan and the "
            + "payment request.")
    @JsonProperty("tranId")
    @NotNull
    public String getTranId() {
        return tranId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PaymentConfirmation {\n");

        sb.append("    id: ").append(Utils.toIndentedString(id)).append("\n");
        sb.append("    requestId: ").append(Utils.toIndentedString(requestId)).append("\n");
        sb.append("    thirdPartyIdentifiers: ").append(Utils.toIndentedString(thirdPartyIdentifiers)).append("\n");
        sb.append("    time: ").append(Utils.toIndentedString(time)).append("\n");
        sb.append("    rrn: ").append(Utils.toIndentedString(rrn)).append("\n");
        sb.append("    stan: ").append(Utils.toIndentedString(stan)).append("\n");
        sb.append("    tranId: ").append(Utils.toIndentedString(tranId)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
