package io.electrum.qr.api.model;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.electrum.vas.Utils;
import io.electrum.vas.model.BasicReversal;
import io.electrum.vas.model.Institution;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Reverse a previous {@link PaymentRequest}. This may be due to a cancellation at the POS or because the original
 * {@link PaymentRequest} is in an unknown state.
 **/

@ApiModel(description = "Reverse a previous PaymentRequest. This may be due to a cancellation at the POS or because the original PaymentRequest is in an unknown state.")
public class PaymentReversal extends BasicReversal {

   protected Institution partner = null;
   protected String tranId = null;

   /**
    * Data relating to the entity to which the original PaymentRequest was submitted.
    **/
   public PaymentReversal partner(Institution partner) {
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
   public PaymentReversal tranId(String tranId) {
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

   @Override
   public boolean equals(Object o) {
      if (this == o)
         return true;
      if (o == null || getClass() != o.getClass())
         return false;
      if (!super.equals(o))
         return false;
      PaymentReversal request = (PaymentReversal) o;
      return super.equals(o) && Objects.equals(partner, request.partner)
            && Objects.equals(tranId, request.tranId);
   }

   @Override
   public int hashCode() {
      return Objects.hash(super.hashCode(), tranId, partner);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class PaymentReversal {\n");

      sb.append("    tranId: ").append(Utils.toIndentedString(tranId)).append("\n");
      sb.append("    partner: ").append(Utils.toIndentedString(partner)).append("\n");
      sb.append("}");
      sb.append(super.toString());
      return sb.toString();
   }
}
