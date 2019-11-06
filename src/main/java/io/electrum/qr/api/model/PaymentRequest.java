package io.electrum.qr.api.model;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.qr.api.model.helper.PartnerField;
import io.electrum.qr.api.model.helper.TranIdField;
import io.electrum.vas.Utils;
import io.electrum.vas.model.Amounts;
import io.electrum.vas.model.Institution;
import io.electrum.vas.model.Transaction;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A request to effect a payment with a linked QR code. Such requests originate from the Merchant's system and are
 * typically directed to the Partner for processing. If the Partner for a {@link PaymentRequest} is not known, then the
 * {@link PaymentRequest} may be directed to an intermediate system which receives {@link ScanNotification} messages
 * from Partners. This intermediate system is then responsible for identifying the correct Partner to which a
 * {@link PaymentRequest} should be directed.
 **/

@ApiModel(description = "A request to effect a payment with a linked QR code. Such requests originate from the Merchant's "
      + "system and are typically directed to the Partner for processing. If the Partner for a PaymentRequest is not known, then "
      + "the PaymentRequest may be directed to an intermediate system which receives ScanNotification messages from Partners. "
      + "This intermediate system is then responsible for identifying the correct Partner to which a PaymentRequest should "
      + "be directed.")
public class PaymentRequest extends Transaction implements PartnerField, TranIdField {

   protected Institution partner = null;
   protected Amounts amounts = null;
   protected String tranId = null;
   protected String partnerPaymentToken = null;

   /**
    * Data relating to the entity who will process the payment. This identifies the entity who provided the
    * {@link ScanNotification} for the QR code associated with this {@link PaymentRequest}. This should be populated if
    * known to aid in routing the {@link PaymentRequest} to the entity which provided the {@link ScanNotification}.
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

   @ApiModelProperty(required = true, value = "The amounts pertaining to the transaction. Note that the requestAmount "
         + "herein maybe be different to that submitted when the QR code was requested. This request amount describes "
         + "the actual amount to be processed in the transaction.")
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
    * The unique transaction identifier related to this transaction. Retailers must set this to the same value as that
    * returned in the tranId field of the {@link CreateQrCodeResponse} that preceded this {@link PaymentRequest}.
    * Partners may associate this {@link PaymentRequest} with the QR code whose {@link ScanNotification} they submitted
    * with this value.
    **/
   public PaymentRequest tranId(String tranId) {
      this.tranId = tranId;
      return this;
   }

   @ApiModelProperty(required = true, value = "The unique transaction identifier related to this transaction. "
         + "Retailers must set this to the same value as that returned in the tranId field of the CreateQrCodeResponse "
         + "that preceded this PaymentRequest. Partners may associate this PaymentRequest with the QR code whose "
         + "ScanNotification they submitted with this value.")
   @JsonProperty("tranId")
   @NotNull
   public String getTranId() {
      return tranId;
   }

   public void setTranId(String tranId) {
      this.tranId = tranId;
   }

   /**
    * A payment token received from the Partner in the {@link ScanNotification}. A Partner may provide such a value in
    * the {@link ScanNotification} so that it is included in the {@link PaymentRequest} to the Partner. This field
    * should be populated if known. A Partner may expect to receive this value in the {@link PaymentRequest} if it was
    * provided in the {@link ScanNotification}.
    **/
   public PaymentRequest partnerPaymentToken(String partnerPaymentToken) {
      this.partnerPaymentToken = partnerPaymentToken;
      return this;
   }

   @ApiModelProperty(required = false, value = "A payment token received from the Partner in the ScanNotification. A Partner "
         + "may provide such a value in the ScanNotification so that it is included in the PaymentRequest to the Partner. "
         + "This field should be populated if known. A Partner may expect to receive this value in the PaymentRequest if it "
         + "was provided in the ScanNotification.")
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
      sb.append("class PaymentRequest {").append(System.lineSeparator());

      sb.append("    amounts: ").append(Utils.toIndentedString(amounts)).append(System.lineSeparator());
      sb.append("    partner: ").append(Utils.toIndentedString(partner)).append(System.lineSeparator());
      sb.append("    tranId: ").append(Utils.toIndentedString(tranId)).append(System.lineSeparator());
      sb.append("    qrCode: ").append(Utils.toIndentedString(partnerPaymentToken)).append(System.lineSeparator());
      sb.append("}").append(System.lineSeparator());
      sb.append(super.toString());
      return sb.toString();
   }
}
