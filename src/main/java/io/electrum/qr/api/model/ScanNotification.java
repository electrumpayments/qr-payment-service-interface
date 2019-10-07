package io.electrum.qr.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.electrum.qr.api.model.helper.PartnerField;
import io.electrum.qr.api.model.helper.TranIdField;
import io.electrum.vas.Utils;
import io.electrum.vas.model.Institution;
import io.electrum.vas.model.ThirdPartyIdentifier;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.joda.time.DateTime;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A notification sent by the Partner indicating that the Partner received a scan of the QR code linked to the
 * transaction ID. Any PaymentRequest with a matching tranId value should be forwarded to the Partner for processing.
 **/

@ApiModel(description = "A request to effect a payment with a linked QR code scan.")
public class ScanNotification implements PartnerField, TranIdField {

   protected String id = null;
   protected DateTime time = null;
   protected Institution partner = null;
   protected Institution settlementEntity = null;
   protected List<ThirdPartyIdentifier> thirdPartyIdentifiers = new ArrayList<>();
   protected String tranId = null;
   protected String partnerPaymentToken = null;

   /**
    * The randomly generated UUID identifying this notification. This may be a variant 3 or 4 as defined in [RFC
    * 4122](https://tools.ietf.org/html/rfc4122)
    **/
   public ScanNotification id(String id) {
      this.id = id;
      return this;
   }

   @ApiModelProperty(required = true, value = "The randomly generated UUID identifying this notification. This may be a variant 3 or 4 as defined in [RFC 4122](https://tools.ietf.org/html/rfc4122)")
   @JsonProperty("id")
   @NotNull
   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   /**
    * The date and time of the message in UTC, as recorded by the sender. The format shall be as defined for date-time
    * in [RFC 3339 section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6). It is recommended that the optional
    * time-secfrac be included up to millisecond precision
    **/
   public ScanNotification time(DateTime time) {
      this.time = time;
      return this;
   }

   @ApiModelProperty(required = true, value = "The date and time of the message as recorded by the sender. The format shall be as defined for date-time in [RFC 3339 section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6). It is recommended that the optional time-secfrac be included up to millisecond precision")
   @JsonProperty("time")
   @NotNull
   @Valid
   public DateTime getTime() {
      return time;
   }

   public void setTime(DateTime time) {
      this.time = time;
   }

   /**
    * Data relating to the entity who should receive associated PaymentRequest messages with a matching tranId value.
    **/
   public ScanNotification partner(Institution partner) {
      this.partner = partner;
      return this;
   }

   @ApiModelProperty(required = true, value = "Data relating to the entity who should receive associated PaymentRequest messages with a matching tranId value.")
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
    * Data relating to the entity with whom the Merchant will settle the transaction.
    **/
   public ScanNotification settlementEntity(Institution settlementEntity) {
      this.settlementEntity = settlementEntity;
      return this;
   }

   @ApiModelProperty(value = "Data relating to the entity with whom the Merchant will settle the transaction.")
   @JsonProperty("settlementEntity")
   @Valid
   public Institution getSettlementEntity() {
      return settlementEntity;
   }

   public void setSettlementEntity(Institution settlementEntity) {
      this.settlementEntity = settlementEntity;
   }

   /**
    * An array of identifiers which identify the transaction within each entity's system.
    **/
   public ScanNotification thirdPartyIdentifiers(List<ThirdPartyIdentifier> transactionIdentifiers) {
      this.thirdPartyIdentifiers = transactionIdentifiers;
      return this;
   }

   @ApiModelProperty(value = "An array of identifiers which identify the transaction within each entity's system.")
   @JsonProperty("thirdPartyIdentifiers")
   @Valid
   public List<ThirdPartyIdentifier> getThirdPartyIdentifiers() {
      return thirdPartyIdentifiers;
   }

   public void setThirdPartyIdentifiers(List<ThirdPartyIdentifier> transactionIdentifiers) {
      this.thirdPartyIdentifiers = transactionIdentifiers;
   }

   /**
    * The transaction identifier encoded within the QR Code which was scanned.
    **/
   public ScanNotification tranId(String tranId) {
      this.tranId = tranId;
      return this;
   }

   @ApiModelProperty(required = true, value = "The transaction identifier encoded within the QR Code which was scanned.")
   @JsonProperty("tranId")
   @NotNull
   public String getTranId() {
      return tranId;
   }

   public void setTranId(String tranId) {
      this.tranId = tranId;
   }

   /**
    * A payment token received from the partner in the ScanNotification. If supplied by the Partner then it will be
    * echoed in the PaymentRequest to the Partner.
    **/
   public ScanNotification partnerPaymentToken(String partnerPaymentToken) {
      this.partnerPaymentToken = partnerPaymentToken;
      return this;
   }

   @ApiModelProperty(required = false, value = "A payment token received from the partner in the ScanNotification. If supplied by the Partner then it will be echoed in the PaymentRequest to the Partner.")
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
      ScanNotification request = (ScanNotification) o;
      return Objects.equals(id, request.id) && Objects.equals(time, request.time)
            && Objects.equals(partner, request.partner)
            && Objects.equals(thirdPartyIdentifiers, request.thirdPartyIdentifiers)
            && Objects.equals(tranId, request.tranId)
            && Objects.equals(partnerPaymentToken, request.partnerPaymentToken);
   }

   @Override
   public int hashCode() {
      return Objects.hash(super.hashCode(), id, time, partner, thirdPartyIdentifiers, tranId, partnerPaymentToken);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class ScanNotification {\n");

      sb.append("    id: ").append(Utils.toIndentedString(id)).append("\n");
      sb.append("    time: ").append(Utils.toIndentedString(time)).append("\n");
      sb.append("    partner: ").append(Utils.toIndentedString(partner)).append("\n");
      sb.append("    thirdPartyIdentifiers: ").append(Utils.toIndentedString(thirdPartyIdentifiers)).append("\n");
      sb.append("    tranId: ").append(Utils.toIndentedString(tranId)).append("\n");
      sb.append("    partnerPaymentToken: ").append(Utils.toIndentedString(partnerPaymentToken)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
