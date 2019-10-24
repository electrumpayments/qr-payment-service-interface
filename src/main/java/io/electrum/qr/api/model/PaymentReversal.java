package io.electrum.qr.api.model;

import java.util.Objects;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.qr.api.model.helper.PartnerField;
import io.electrum.qr.api.model.helper.TranIdField;
import io.electrum.vas.Utils;
import io.electrum.vas.model.BasicReversal;
import io.electrum.vas.model.Institution;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Reverse a previous {@link PaymentRequest}. This may be due to a cancellation at the POS or because the original
 * {@link PaymentRequest} failed or is in an unknown state. Where possible all optional fields should be supplied to
 * ensure smooth processing. If optional fields are not present then processing may require retrieval of the original
 * transaction leading to unnecessary processing overheads.
 **/

@ApiModel(description = "Reverse a previous PaymentRequest. This may be due to a cancellation at the POS or because the original PaymentRequest failed or is in an unknown state. Where possible all optional fields should be supplied to ensure smooth processing. If optional fields are not present then processing may require retrieval of the original transaction leading to unnecessary processing overheads.")
public class PaymentReversal extends BasicReversal implements PartnerField, TranIdField {

   protected Institution partner = null;
   protected String tranId = null;

   /**
    * An echo of the value in the original {@link PaymentRequest}.
    **/
   public PaymentReversal partner(Institution partner) {
      this.partner = partner;
      return this;
   }

   @ApiModelProperty(required = false, value = "An echo of the value in the original PaymentRequest.")
   @JsonProperty("partner")
   @Valid
   public Institution getPartner() {
      return partner;
   }

   public void setPartner(Institution partner) {
      this.partner = partner;
   }

   /**
    * An echo of the value in the original {@link PaymentRequest}.
    **/
   public PaymentReversal tranId(String tranId) {
      this.tranId = tranId;
      return this;
   }

   @ApiModelProperty(required = false, value = "An echo of the value in the original PaymentRequest.")
   @JsonProperty("tranId")
   public String getTranId() {
      return tranId;
   }

   public void setTranId(String tranId) {
      this.tranId = tranId;
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
      return super.equals(o) && Objects.equals(partner, request.partner) && Objects.equals(tranId, request.tranId);
   }

   @Override
   public int hashCode() {
      return Objects.hash(super.hashCode(), tranId, partner);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class PaymentReversal {").append(System.lineSeparator());

      sb.append("    partner: ").append(Utils.toIndentedString(partner)).append(System.lineSeparator());
      sb.append("    tranId: ").append(Utils.toIndentedString(tranId)).append(System.lineSeparator());
      sb.append("}").append(System.lineSeparator());
      sb.append(super.toString());
      return sb.toString();
   }
}
