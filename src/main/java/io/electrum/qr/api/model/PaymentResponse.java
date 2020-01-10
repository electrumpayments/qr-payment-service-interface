package io.electrum.qr.api.model;

import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.qr.api.model.helper.PartnerField;
import io.electrum.qr.api.model.helper.TranIdField;
import io.electrum.vas.Utils;
import io.electrum.vas.model.Amounts;
import io.electrum.vas.model.Institution;
import io.electrum.vas.model.Tender;
import io.electrum.vas.model.Transaction;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The response to a successfully processed {@link PaymentRequest}.
 **/

@ApiModel(description = "The response to a successful payment with a linked QR code scan.")
public class PaymentResponse extends Transaction implements PartnerField, TranIdField {

   protected Institution partner = null;
   protected List<Tender> tenders = null;
   protected Amounts amounts = null;
   protected String tranId = null;
   protected String partnerPaymentToken = null;

   /**
    * Data relating to the entity who processed the {@link PaymentRequest}. This identifies the entity who provided the
    * {@link ScanNotification} for the QR code associated with this payment.
    **/
   public PaymentResponse partner(Institution partner) {
      this.partner = partner;
      return this;
   }

   @ApiModelProperty(required = true, value = "Data relating to the entity who processed the PaymentRequest. This identifies "
         + "the entity who provided the ScanNotification for the QR code associated with this payment.")
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
    * An array of tenders used to pay for the transaction. This may be used to describe the payment which was effected
    * as a result of the QR code scan e.g. the card detail ultimately used for the payment.
    **/
   public PaymentResponse tenders(List<Tender> tenders) {
      this.tenders = tenders;
      return this;
   }

   @ApiModelProperty(required = false, value = "An array of tenders used to pay for the transaction. This may be used to describe the payment which was effected as a result of the QR code scan e.g. the card detail ultimately used for the payment.")
   @JsonProperty("tenders")
   public List<Tender> getTenders() {
      return tenders;
   }

   public void setTenders(List<Tender> tenders) {
      this.tenders = tenders;
   }

   /**
    * The amounts pertaining to the transaction.
    **/
   public PaymentResponse amounts(Amounts amounts) {
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
    * This value is echoed from the {@link PaymentRequest}.
    **/
   public PaymentResponse tranId(String tranId) {
      this.tranId = tranId;
      return this;
   }

   @ApiModelProperty(required = true, value = "This value is echoed from the PaymentRequest.")
   @JsonProperty("tranId")
   @NotNull
   public String getTranId() {
      return tranId;
   }

   public void setTranId(String tranId) {
      this.tranId = tranId;
   }

   /**
    * This value is echoed from the {@link PaymentRequest}.
    **/
   public PaymentResponse partnerPaymentToken(String partnerPaymentToken) {
      this.partnerPaymentToken = partnerPaymentToken;
      return this;
   }

   @ApiModelProperty(required = false, value = "This value is echoed from the PaymentRequest.")
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
      PaymentResponse request = (PaymentResponse) o;
      return Objects.equals(amounts, request.amounts) && Objects.equals(partner, request.partner)
            && Objects.equals(tenders, request.tenders) && Objects.equals(tranId, request.tranId)
            && Objects.equals(partnerPaymentToken, request.partnerPaymentToken);
   }

   @Override
   public int hashCode() {
      return Objects.hash(super.hashCode(), amounts, tranId, partnerPaymentToken);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class PaymentResponse {").append(System.lineSeparator());
      sb.append("    amounts: ").append(Utils.toIndentedString(amounts)).append(System.lineSeparator());
      sb.append("    tenders: ").append(Utils.toIndentedString(tenders)).append(System.lineSeparator());
      sb.append("    partner: ").append(Utils.toIndentedString(partner)).append(System.lineSeparator());
      sb.append("    tranId: ").append(Utils.toIndentedString(tranId)).append(System.lineSeparator());
      sb.append("    qrCode: ").append(Utils.toIndentedString(partnerPaymentToken)).append(System.lineSeparator());
      sb.append("}").append(System.lineSeparator());
      sb.append(super.toString());
      return sb.toString();
   }
}
