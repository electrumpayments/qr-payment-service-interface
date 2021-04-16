package io.electrum.qr.api.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import io.electrum.vas.interfaces.HasAmounts;
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
 * A base entity describing the request for a QR code.
 **/

@ApiModel(description = "A base entity describing the request for a QR code.")
public class CreateQrCodeMessage implements HasAmounts {

   protected String id = null;
   protected DateTime time = null;
   protected Originator originator = null;
   protected Institution client = null;
   protected List<ThirdPartyIdentifier> thirdPartyIdentifiers = new ArrayList<>();
   protected String rrn = null;
   protected String stan = null;
   protected Amounts amounts = null;

   /**
    * The randomly generated UUID identifying this request. This may be a variant 3 or 4 as defined in [RFC
    * 4122](https://tools.ietf.org/html/rfc4122)
    **/
   public CreateQrCodeMessage id(String id) {
      this.id = id;
      return this;
   }

   @ApiModelProperty(required = true, value = "The randomly generated UUID identifying this request. This may be a "
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
    **/
   public CreateQrCodeMessage time(DateTime time) {
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
    * Data relating to the originator of the request.
    **/
   public CreateQrCodeMessage originator(Originator originator) {
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
    * Data relating to the sender of the CreateQrCodeRequest.
    **/
   public CreateQrCodeMessage client(Institution client) {
      this.client = client;
      return this;
   }

   @ApiModelProperty(required = true, value = "Data relating to the sender of the request.")
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
   public CreateQrCodeMessage thirdPartyIdentifiers(List<ThirdPartyIdentifier> transactionIdentifiers) {
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
   public CreateQrCodeMessage rrn(String rrn) {
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
   public CreateQrCodeMessage stan(String stan) {
      this.stan = stan;
      return this;
   }

   @ApiModelProperty(required = false, value = "The System Trace Audit Number can be used to locate transactions across "
         + "different systems.")
   @JsonProperty("stan")
   public String getStan() {
      return stan;
   }

   public void setStan(String stan) {
      this.stan = stan;
   }

   /**
    * The amounts pertaining to the QR code to be created.
    **/
   public CreateQrCodeMessage amounts(Amounts amounts) {
      this.amounts = amounts;
      return this;
   }

   @ApiModelProperty(required = false, value = "The amounts pertaining to the QR code to be created.")
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

   @Override
   public boolean equals(Object o) {
      if (this == o)
         return true;
      if (o == null || getClass() != o.getClass())
         return false;
      CreateQrCodeMessage request = (CreateQrCodeMessage) o;
      return Objects.equals(id, request.id) && Objects.equals(time, request.time)
            && Objects.equals(originator, request.originator) && Objects.equals(client, request.client)
            && Objects.equals(thirdPartyIdentifiers, request.thirdPartyIdentifiers) && Objects.equals(rrn, request.rrn)
            && Objects.equals(stan, request.stan) && Objects.equals(amounts, request.amounts);
   }

   @Override
   public int hashCode() {
      return Objects.hash(id, time, originator, client, thirdPartyIdentifiers, rrn, stan, amounts);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class CreateQrCodeMessage {\n");

      sb.append("    id: ").append(Utils.toIndentedString(id)).append(System.lineSeparator());
      sb.append("    time: ").append(Utils.toIndentedString(time)).append(System.lineSeparator());
      sb.append("    originator: ").append(Utils.toIndentedString(originator)).append(System.lineSeparator());
      sb.append("    client: ").append(Utils.toIndentedString(client)).append(System.lineSeparator());
      sb.append("    thirdPartyIdentifiers: ").append(Utils.toIndentedString(thirdPartyIdentifiers)).append(System.lineSeparator());
      sb.append("    rrn: ").append(Utils.toIndentedString(rrn)).append(System.lineSeparator());
      sb.append("    stan: ").append(Utils.toIndentedString(stan)).append(System.lineSeparator());
      sb.append("    amounts: ").append(Utils.toIndentedString(amounts)).append(System.lineSeparator());
      sb.append("}").append(System.lineSeparator());
      return sb.toString();
   }
}
