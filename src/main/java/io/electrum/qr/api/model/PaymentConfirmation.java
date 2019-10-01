package io.electrum.qr.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.electrum.qr.api.model.helper.Partner;
import io.electrum.qr.api.model.helper.TranId;
import io.electrum.vas.Utils;
import io.electrum.vas.model.BasicAdvice;
import io.electrum.vas.model.Institution;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Confirm that a previous {@link PaymentRequest} has completed successfully at the POS.
 **/

@ApiModel(description = "Confirm that a previous {@link PaymentRequest} has completed successfully at the POS.")
public class PaymentConfirmation extends BasicAdvice implements Partner, TranId {

   protected Institution partner = null;
   protected String tranId = null;

   /**
    * Data relating to the entity to which the original PaymentRequest was submitted.
    **/
   public PaymentConfirmation partner(Institution partner) {
      this.partner = partner;
      return this;
   }

   @ApiModelProperty(required = false, value = "Data relating to the entity to which the original PaymentRequest was submitted.")
   @JsonProperty("partner")
   @Valid
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
   public PaymentConfirmation tranId(String tranId) {
      this.tranId = tranId;
      return this;
   }

   @ApiModelProperty(required = false, value = "The unique transaction identifier related to this transaction. This "
         + "transaction identifier was encoded within the QR Code and used to associate the scan and the "
         + "payment request.")
   @JsonProperty("tranId")
   public String getTranId() {
      return tranId;
   }

   public void setTranId(String tranId) {
      this.tranId = tranId;
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class PaymentConfirmation {\n");

      sb.append("    partner: ").append(Utils.toIndentedString(partner)).append("\n");
      sb.append("    tranId: ").append(Utils.toIndentedString(tranId)).append("\n");
      sb.append("}");
      sb.append(super.toString());
      return sb.toString();
   }
}
