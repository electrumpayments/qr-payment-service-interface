package io.electrum.qr.api.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.vas.Utils;
import io.electrum.vas.model.Amounts;
import io.electrum.vas.model.Institution;
import io.electrum.vas.model.Originator;
import io.electrum.vas.model.ThirdPartyIdentifier;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A notification sent by the partner indicating that the partner received a scan of the QR code linked to the
 * transaction ID.
 **/

@ApiModel(description = "A request to effect a payment with a linked QR code scan.")
public class CreateQrCodeResponse {

   protected String id = null;
   protected DateTime time = null;
   protected Originator originator = null;
   protected Institution client = null;
   protected List<ThirdPartyIdentifier> thirdPartyIdentifiers = new ArrayList<ThirdPartyIdentifier>();
   protected String rrn = null;
   protected String stan = null;
   protected Amounts amounts = null;
   protected String tranId = null;
   protected String qrCode = null;

   /**
    * The randomly generated UUID identifying this notification. This may be a variant 3 or 4 as defined in [RFC
    * 4122](https://tools.ietf.org/html/rfc4122)
    **/
   public CreateQrCodeResponse id(String id) {
      this.id = id;
      return this;
   }

   @ApiModelProperty(required = true, value = "The randomly generated UUID identifying this notification. THis may be a variant 3 or 4 as defined in [RFC 4122](https://tools.ietf.org/html/rfc4122)")
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
   public CreateQrCodeResponse time(DateTime time) {
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
    * Data relating to the originator of the request.
    **/
   public CreateQrCodeResponse originator(Originator originator) {
      this.originator = originator;
      return this;
   }

   @ApiModelProperty(required = true, value = "Data relating to the originator of the request.")
   @JsonProperty("originator")
   @Valid
   @NotNull
   public Originator getOriginator() {
      return originator;
   }

   public void setOriginator(Originator originator) {
      this.originator = originator;
   }

   /**
    * Data relating to the sender of the original CreateQrCodeRequest.
    **/
   public CreateQrCodeResponse client(Institution client) {
      this.client = client;
      return this;
   }

   @ApiModelProperty(required = true, value = "Data relating to the sender of the original CreateQrCodeRequest.")
   @JsonProperty("client")
   @Valid
   @NotNull
   public Institution getClient() {
      return client;
   }

   public void setClient(Institution client) {
      this.client = client;
   }

   /**
    * An array of identifiers which identify the transaction within each entity's system.
    **/
   public CreateQrCodeResponse thirdPartyIdentifiers(List<ThirdPartyIdentifier> transactionIdentifiers) {
      this.thirdPartyIdentifiers = transactionIdentifiers;
      return this;
   }

   @ApiModelProperty(value = "An array of identifiers which each identify the transaction within each entity's system.")
   @JsonProperty("thirdPartyIdentifiers")
   @Valid
   public List<ThirdPartyIdentifier> getThirdPartyIdentifiers() {
      return thirdPartyIdentifiers;
   }

   public void setThirdPartyIdentifiers(List<ThirdPartyIdentifier> transactionIdentifiers) {
      this.thirdPartyIdentifiers = transactionIdentifiers;
   }

   /**
    * This is a reference set by the original source of the request.
    **/
   public CreateQrCodeResponse rrn(String rrn) {
      this.rrn = rrn;
      return this;
   }

   @ApiModelProperty(required = false, value = "This is a reference set by the original source of the request.")
   @JsonProperty("rrn")
   public String getRrn() {
      return rrn;
   }

   public void setRrn(String rrn) {
      this.rrn = rrn;
   }

   /**
    * The System Trace Audit Number can be used to locate transactions across different systems.
    **/
   public CreateQrCodeResponse stan(String stan) {
      this.stan = stan;
      return this;
   }

   @ApiModelProperty(required = false, value = "The System Trace Audit Number can be used to locate transactions across different systems.")
   @JsonProperty("stan")
   public String getStan() {
      return stan;
   }

   public void setStan(String stan) {
      this.tranId = stan;
   }

   /**
    * The amounts pertaining to the QR code which was created.
    **/
   public CreateQrCodeResponse amounts(Amounts amounts) {
      this.amounts = amounts;
      return this;
   }

   @ApiModelProperty(required = false, value = "The amounts pertaining to the QR code which was created.")
   @JsonProperty("amounts")
   @Valid
   public Amounts getAmounts() {
      return amounts;
   }

   public void setAmounts(Amounts amounts) {
      this.amounts = amounts;
   }

   /**
    * The transaction identifier encoded within the QR Code which was scanned.
    **/
   public CreateQrCodeResponse tranId(String tranId) {
      this.tranId = tranId;
      return this;
   }

   @ApiModelProperty(required = true, value = "The transaction identifier encoded within the QR Code which was scanned. This value must be provided in subsequent pay and reversePayment operations.")
   @JsonProperty("tranId")
   @NotNull
   public String getTranId() {
      return tranId;
   }

   public void setTranId(String tranId) {
      this.tranId = tranId;
   }

   /**
    * The full set of data to be encoded in the graphical QR code. The data is provided as an EMVCo compliant string.
    * This value must be provided in subsequent pay and reversePayment operations.
    **/
   public CreateQrCodeResponse qrCode(String qrCode) {
      this.qrCode = qrCode;
      return this;
   }

   @ApiModelProperty(required = true, value = "The full set of data to be encoded in the graphical QR code. The data is provided as an EMVCo compliant string.")
   @JsonProperty("qrCode")
   @NotNull
   public String getQrCode() {
      return qrCode;
   }

   public void setQrCode(String qrCode) {
      this.qrCode = qrCode;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o)
         return true;
      if (o == null || getClass() != o.getClass())
         return false;
      if (!super.equals(o))
         return false;
      CreateQrCodeResponse request = (CreateQrCodeResponse) o;
      return Objects.equals(id, request.id) && Objects.equals(time, request.time)
            && Objects.equals(originator, request.originator) && Objects.equals(client, request.client)
            && Objects.equals(thirdPartyIdentifiers, request.thirdPartyIdentifiers) && Objects.equals(rrn, request.rrn)
            && Objects.equals(stan, request.stan) && Objects.equals(amounts, request.amounts)
            && Objects.equals(tranId, request.tranId) && Objects.equals(qrCode, request.qrCode);
   }

   @Override
   public int hashCode() {
      return Objects.hash(
            super.hashCode(),
            id,
            time,
            originator,
            client,
            thirdPartyIdentifiers,
            rrn,
            stan,
            amounts,
            tranId,
            qrCode);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class CreateQrCodeResponse {\n");

      sb.append("    id: ").append(Utils.toIndentedString(id)).append("\n");
      sb.append("    time: ").append(Utils.toIndentedString(time)).append("\n");
      sb.append("    originator: ").append(Utils.toIndentedString(originator)).append("\n");
      sb.append("    client: ").append(Utils.toIndentedString(client)).append("\n");
      sb.append("    thirdPartyIdentifiers: ").append(Utils.toIndentedString(thirdPartyIdentifiers)).append("\n");
      sb.append("    rrn: ").append(Utils.toIndentedString(rrn)).append("\n");
      sb.append("    stan: ").append(Utils.toIndentedString(stan)).append("\n");
      sb.append("    amounts: ").append(Utils.toIndentedString(amounts)).append("\n");
      sb.append("    tranId: ").append(Utils.toIndentedString(tranId)).append("\n");
      sb.append("    qrCode: ").append(Utils.toIndentedString(qrCode)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
