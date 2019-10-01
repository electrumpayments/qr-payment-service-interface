package io.electrum.qr.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.electrum.qr.api.model.helper.Partner;
import io.electrum.qr.api.model.helper.TranId;
import io.electrum.vas.Utils;
import io.electrum.vas.model.Amounts;
import io.electrum.vas.model.Institution;
import io.electrum.vas.model.Transaction;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * A request to effect a payment with a linked QR code scan.
 **/

@ApiModel(description = "A request to effect a payment with a linked QR code scan.")
public class PaymentRequest extends Transaction implements Partner, TranId {

   protected Institution partner = null;
   protected Amounts amounts = null;
   protected String tranId = null;
   protected String partnerPaymentToken = null;

   /**
    * Data relating to the entity who will process the payment.
    **/
   public PaymentRequest partner(Institution partner) {
      this.partner = partner;
      return this;
   }

   @ApiModelProperty(required = true, value = "Data relating to the entity who will process the payment.")
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
    * The amounts pertaining to the transaction.
    **/
   public PaymentRequest amounts(Amounts amounts) {
      this.amounts = amounts;
      return this;
   }

   @ApiModelProperty(required = true, value = "The amounts pertaining to the transaction.")
   @JsonProperty("amounts")
   @Valid
   @NotNull
   public Amounts getAmounts() {
      return amounts;
   }

   public void setAmounts(Amounts amounts) {
      this.amounts = amounts;
   }

   /**
    * The unique transaction identifier related to this transaction. This transaction identifier is encoded within the
    * QR Code and is to be used to associate the scan and the payment request.
    **/
   public PaymentRequest tranId(String tranId) {
      this.tranId = tranId;
      return this;
   }

   @ApiModelProperty(required = true, value = "The unique transaction identifier related to this transaction. This "
         + "transaction identifier is encoded within the QR Code and is to be used to associate the scan and the "
         + "payment request.")
   @JsonProperty("tranId")
   @NotNull
   public String getTranId() {
      return tranId;
   }

   public void setTranId(String tranId) {
      this.tranId = tranId;
   }

   /**
    * A payment token received from the Partner in the ScanNotification.
    **/
   public PaymentRequest partnerPaymentToken(String partnerPaymentToken) {
      this.partnerPaymentToken = partnerPaymentToken;
      return this;
   }

   @ApiModelProperty(required = false, value = "A payment token received from the Partner in the ScanNotification.")
   @JsonProperty("qrCode")
   public String getPartnerPaymentToken() {
      return partnerPaymentToken;
   }

   public void setPartnerPaymentToken(String partnerPaymentToken) {
      this.partnerPaymentToken = partnerPaymentToken;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o)
         return true;
      if (o == null || getClass() != o.getClass())
         return false;
      if (!super.equals(o))
         return false;
      PaymentRequest request = (PaymentRequest) o;
      return Objects.equals(amounts, request.amounts) && Objects.equals(partner, request.partner)
            && Objects.equals(tranId, request.tranId)
            && Objects.equals(partnerPaymentToken, request.partnerPaymentToken);
   }

   @Override
   public int hashCode() {
      return Objects.hash(super.hashCode(), amounts, partner, tranId, partnerPaymentToken);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class PaymentRequest {\n");

      sb.append("    amounts: ").append(Utils.toIndentedString(amounts)).append("\n");
      sb.append("    partner: ").append(Utils.toIndentedString(partner)).append("\n");
      sb.append("    tranId: ").append(Utils.toIndentedString(tranId)).append("\n");
      sb.append("    qrCode: ").append(Utils.toIndentedString(partnerPaymentToken)).append("\n");
      sb.append("}");
      sb.append(super.toString());
      return sb.toString();
   }
}
