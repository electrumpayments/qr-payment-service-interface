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
    * Data relating to the entity who will process the payment. This identifies the entity who provided the
    * ScanNotification for the QR code associated with this PaymentRequest. This should be populated if known to aid in
    * routing the PaymentRequest to the entity which provided the ScanNotification.
    **/
   public PaymentRequest partner(Institution partner) {
      this.partner = partner;
      return this;
   }

   @ApiModelProperty(value = "Data relating to the entity who will process the payment. This identifies the entity who provided the "
         + "ScanNotification for the QR code associated with this PaymentRequest. This should be populated if known to aid in "
         + "routing the PaymentRequest to the entity which provided the ScanNotification.")
   @JsonProperty("partner")
   @Valid
   public Institution getPartner() {
      return partner;
   }

   public void setPartner(Institution partner) {
      this.partner = partner;
   }

   /**
    * The amounts pertaining to the transaction. Note that the requestAmount herein maybe be different to that submitted
    * when the QR code was requested. This request amount describes the actual amount to be processed in the
    * transaction.
    **/
   public PaymentRequest amounts(Amounts amounts) {
      this.amounts = amounts;
      return this;
   }

   @ApiModelProperty(required = true, value = "The amounts pertaining to the transaction. Note that the requestAmount herein maybe be different to that submitted when the QR code was requested. This request amount describes the actual amount to be processed in the transaction.")
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
    * QR Code and is to be used to associate the scan and the payment request. This should be the same as the value
    * returned in the tranId field of the CreateQrCodeResponse.
    **/
   public PaymentRequest tranId(String tranId) {
      this.tranId = tranId;
      return this;
   }

   @ApiModelProperty(required = true, value = "The unique transaction identifier related to this transaction. This "
         + "transaction identifier is encoded within the QR Code and is to be used to associate the scan and the "
         + "payment request. This should be the same as the value returned in the tranId field of the CreateQrCodeResponse.")
   @JsonProperty("tranId")
   @NotNull
   public String getTranId() {
      return tranId;
   }

   public void setTranId(String tranId) {
      this.tranId = tranId;
   }

   /**
    * A payment token received from the Partner in the ScanNotification. A Partner may provide such a value in the
    * ScanNotification so that it is included in the PaymentRequest to the partner. This field should be populated if
    * known.
    **/
   public PaymentRequest partnerPaymentToken(String partnerPaymentToken) {
      this.partnerPaymentToken = partnerPaymentToken;
      return this;
   }

   @ApiModelProperty(required = false, value = "A payment token received from the Partner in the ScanNotification. A Partner may provide such a value in the ScanNotification so that it is included in the PaymentRequest to the partner. This field should be populated if known.")
   @JsonProperty("partnerPaymentToken")
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
