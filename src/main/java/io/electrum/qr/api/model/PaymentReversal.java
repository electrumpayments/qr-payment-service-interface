package io.electrum.qr.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.electrum.qr.api.model.helper.Partner;
import io.electrum.qr.api.model.helper.TranId;
import io.electrum.vas.Utils;
import io.electrum.vas.model.BasicReversal;
import io.electrum.vas.model.Institution;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Reverse a previous {@link PaymentRequest}. This may be due to a cancellation at the POS or because the original
 * {@link PaymentRequest} is in an unknown state.
 **/

@ApiModel(description = "Reverse a previous {@link PaymentRequest}. This may be due to a cancellation at the POS or because the original {@link PaymentRequest} is in an unknown state.")
public class PaymentReversal extends BasicReversal implements Partner, TranId {

   protected Institution partner = null;
   protected String tranId = null;

   /**
    * Data relating to the entity who will process the payment.
    **/
   public PaymentReversal partner(Institution partner) {
      this.partner = partner;
      return this;
   }

   @ApiModelProperty(required = false, value = "Data relating to the entity who will process the payment.")
   @JsonProperty("partner")
   @Valid
   @NotNull
   public Institution getPartner() {
      return partner;
   }

   public void setPartner(Institution partner) {
      this.partner = partner;
   }

   /**
    * The unique transaction identifier related to this transaction. This transaction identifier was encoded within the
    * QR Code and used to associate the scan and the payment request.
    **/
   public PaymentReversal tranId(String tranId) {
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

   public void setTranId(String tranId) {
      this.tranId = tranId;
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class PaymentReversal {\n");

      sb.append("    id: ").append(Utils.toIndentedString(id)).append("\n");
      sb.append("    requestId: ").append(Utils.toIndentedString(requestId)).append("\n");
      sb.append("    thirdPartyIdentifiers: ").append(Utils.toIndentedString(thirdPartyIdentifiers)).append("\n");
      sb.append("    time: ").append(Utils.toIndentedString(time)).append("\n");
      sb.append("    tranId: ").append(Utils.toIndentedString(tranId)).append("\n");
      sb.append("    partner: ").append(Utils.toIndentedString(partner)).append("\n");
      sb.append("    reversalReason: ").append(Utils.toIndentedString(reversalReason)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
