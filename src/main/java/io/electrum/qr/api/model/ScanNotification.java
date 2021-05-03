package io.electrum.qr.api.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.qr.api.model.helper.PartnerField;
import io.electrum.qr.api.model.helper.TranIdField;
import io.electrum.vas.Utils;
import io.electrum.vas.interfaces.HasAmounts;
import io.electrum.vas.model.Amounts;
import io.electrum.vas.model.Institution;
import io.electrum.vas.model.ThirdPartyIdentifier;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A notification sent by the Partner indicating that the Partner received a scan of the QR code linked to the
 * transaction ID. Any {@link PaymentRequest} with a matching tranId value should be forwarded to the Partner for
 * processing.
 **/

@ApiModel(description = "A notification sent by the Partner indicating that the Partner received a scan of the QR code "
      + "linked to the transaction ID. Any PaymentRequest with a matching tranId value should be forwarded to the Partner "
      + "for processing.")
public class ScanNotification implements PartnerField, TranIdField, HasAmounts {

   protected String id = null;
   protected DateTime time = null;
   protected Institution partner = null;
   protected Institution settlementEntity = null;
   protected Institution receiver = null;
   protected List<ThirdPartyIdentifier> thirdPartyIdentifiers = new ArrayList<>();
   protected Amounts amounts = null;
   protected String tranId = null;
   protected String partnerPaymentToken = null;

   /**
    * The randomly generated UUID identifying this notification. This may be a variant 3 or 4 as defined in [RFC
    * 4122](https://tools.ietf.org/html/rfc4122)
    *
    * @param id
    *           The ID of this request.
    * @return this object.
    **/
   public ScanNotification id(String id) {
      this.id = id;
      return this;
   }

   @ApiModelProperty(required = true, value = "The randomly generated UUID identifying this notification. This may be a "
         + "variant 3 or 4 as defined in [RFC 4122](https://tools.ietf.org/html/rfc4122)")
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
    *
    * @param time
    *           The time that this request was created.
    * @return this object.
    **/
   public ScanNotification time(DateTime time) {
      this.time = time;
      return this;
   }

   @ApiModelProperty(required = true, value = "The date and time of the message as recorded by the sender. The format "
         + "shall be as defined for date-time in [RFC 3339 section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6). "
         + "It is recommended that the optional time-secfrac be included up to millisecond precision")
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
    * Data relating to the entity whose customer scanned a QR code. {@link PaymentRequest} messages which have a
    * matching tranId value should be be sent to the Partner for processing.
    *
    * @param partner
    *           The partner's institution id and name.
    * @return this object.
    **/
   public ScanNotification partner(Institution partner) {
      this.partner = partner;
      return this;
   }

   @ApiModelProperty(required = true, value = "Data relating to the entity whose customer scanned a QR code. "
         + "PaymentRequest messages which have a matching tranId value should be be sent to the Partner for "
         + "processing.")
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
    * Data relating to the entity with whom the Merchant will settle the transaction. A Partner may provide this
    * information if known at the time the QR code was scanned.
    *
    * @param settlementEntity
    *           The settlement entity's institution ID and name.
    * @return this object.
    **/
   public ScanNotification settlementEntity(Institution settlementEntity) {
      this.settlementEntity = settlementEntity;
      return this;
   }

   @ApiModelProperty(value = "Data relating to the entity with whom the Merchant will settle the transaction. A "
         + "Partner may provide this information if known at the time the QR code was scanned.")
   @JsonProperty("settlementEntity")
   @Valid
   public Institution getSettlementEntity() {
      return settlementEntity;
   }

   public void setSettlementEntity(Institution settlementEntity) {
      this.settlementEntity = settlementEntity;
   }

   /**
    * Data relating to the entity which ultimately processes the request. A Partner may provide this information if
    * known at the time the QR code was scanned.
    *
    * @param receiver
    *           The receiver's institution id and name.
    * @return this object.
    **/
   public ScanNotification receiver(Institution receiver) {
      this.receiver = receiver;
      return this;
   }

   @ApiModelProperty(value = "Data relating to the entity which ultimately processes the request. A Partner may "
         + "provide this information if known at the time the QR code was scanned.")
   @JsonProperty("receiver")
   @Valid
   public Institution getReceiver() {
      return receiver;
   }

   public void setReceiver(Institution receiver) {
      this.receiver = receiver;
   }

   /**
    * An array of identifiers which identify the transaction within each entity's system.
    *
    * @param transactionIdentifiers
    *           A list of transaction identifiers.
    * @return this object.
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
    * The amounts pertaining to the QR code which was scanned.
    *
    * @param amounts
    *           The amounts pertaining to the scanned QR code.
    * @return this object.
    **/
   public ScanNotification amounts(Amounts amounts) {
      this.amounts = amounts;
      return this;
   }

   @ApiModelProperty(required = false, value = "The amounts pertaining to the QR code which was scanned.")
   @JsonProperty("amounts")
   @Valid
   @Override
   public Amounts getAmounts() {
      return amounts;
   }

   @Override
   public void setAmounts(Amounts amounts) {
      this.amounts = amounts;
   }

   /**
    * The transaction identifier encoded within the QR Code which was scanned. Any {@link PaymentRequest} with a
    * matching tranId value should be forwarded to the Partner for processing.
    *
    * @param tranId
    *           The transaction identifier
    * @return this object.
    **/
   public ScanNotification tranId(String tranId) {
      this.tranId = tranId;
      return this;
   }

   @ApiModelProperty(required = true, value = "The transaction identifier encoded within the QR Code which was "
         + "scanned. Any PaymentRequest with a matching tranId value should be forwarded to the Partner for processing.")
   @JsonProperty("tranId")
   @NotNull
   public String getTranId() {
      return tranId;
   }

   public void setTranId(String tranId) {
      this.tranId = tranId;
   }

   /**
    * A payment token received from the Partner in the {@link ScanNotification}. If supplied by the Partner then it will
    * be echoed in the PaymentRequest to the Partner.
    *
    * @param partnerPaymentToken
    *           The partner's payment token.
    * @return this object.
    **/
   public ScanNotification partnerPaymentToken(String partnerPaymentToken) {
      this.partnerPaymentToken = partnerPaymentToken;
      return this;
   }

   @ApiModelProperty(required = false, value = "A payment token received from the partner in the ScanNotification. "
         + "If supplied by the Partner then it will be echoed in the PaymentRequest to the Partner.")
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
      ScanNotification request = (ScanNotification) o;
      return Objects.equals(id, request.id) && Objects.equals(time, request.time)
            && Objects.equals(partner, request.partner) && Objects.equals(settlementEntity, request.settlementEntity)
            && Objects.equals(receiver, request.receiver) && Objects.equals(amounts, request.amounts)
            && Objects.equals(thirdPartyIdentifiers, request.thirdPartyIdentifiers)
            && Objects.equals(tranId, request.tranId)
            && Objects.equals(partnerPaymentToken, request.partnerPaymentToken);
   }

   @Override
   public int hashCode() {
      return Objects.hash(
            id,
            time,
            partner,
            settlementEntity,
            receiver,
            thirdPartyIdentifiers,
            amounts,
            tranId,
            partnerPaymentToken);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class ScanNotification {").append(System.lineSeparator());

      sb.append("    id: ").append(Utils.toIndentedString(id)).append(System.lineSeparator());
      sb.append("    time: ").append(Utils.toIndentedString(time)).append(System.lineSeparator());
      sb.append("    partner: ").append(Utils.toIndentedString(partner)).append(System.lineSeparator());
      sb.append("    settlementEntity: ")
            .append(Utils.toIndentedString(settlementEntity))
            .append(System.lineSeparator());
      sb.append("    receiver: ").append(Utils.toIndentedString(receiver)).append(System.lineSeparator());
      sb.append("    thirdPartyIdentifiers: ")
            .append(Utils.toIndentedString(thirdPartyIdentifiers))
            .append(System.lineSeparator());
      sb.append("    amounts: ").append(Utils.toIndentedString(amounts)).append(System.lineSeparator());
      sb.append("    tranId: ").append(Utils.toIndentedString(tranId)).append(System.lineSeparator());
      sb.append("    partnerPaymentToken: ")
            .append(Utils.toIndentedString(partnerPaymentToken))
            .append(System.lineSeparator());
      sb.append("}").append(System.lineSeparator());
      return sb.toString();
   }
}
