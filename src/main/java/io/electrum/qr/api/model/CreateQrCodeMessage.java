package io.electrum.qr.api.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.sdk.masking2.Masked;
import io.electrum.vas.Utils;
import io.electrum.vas.interfaces.HasAmounts;
import io.electrum.vas.model.Amounts;
import io.electrum.vas.model.Customer;
import io.electrum.vas.model.Institution;
import io.electrum.vas.model.Originator;
import io.electrum.vas.model.ThirdPartyIdentifier;
import io.electrum.vas.model.VasMessage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A base entity describing the request for a QR code.
 **/

@ApiModel(description = "A base entity describing the request for a QR code.")
public class CreateQrCodeMessage implements HasAmounts, VasMessage {

   protected String id = null;
   protected DateTime time = null;
   protected Originator originator = null;
   protected Institution client = null;
   protected List<ThirdPartyIdentifier> thirdPartyIdentifiers = new ArrayList<>();
   protected String rrn = null;
   protected String stan = null;
   protected Amounts amounts = null;
   protected Customer customer = null;
   protected QrProperties qrProperties = null;
   protected String destinationAccountId = null;

   /**
    * The randomly generated UUID identifying this request. This may be a variant 3 or 4 as defined in [RFC
    * 4122](https://tools.ietf.org/html/rfc4122)
    *
    * @param id
    *           A UUID string representing the ID of this transaction.
    * @return this object.
    **/
   public CreateQrCodeMessage id(String id) {
      this.id = id;
      return this;
   }

   @ApiModelProperty(required = true, value = "The randomly generated UUID identifying this request. This may be a "
         + "variant 3 or 4 as defined in [RFC 4122](https://tools.ietf.org/html/rfc4122)")
   @JsonProperty("id")
   @NotNull
   @Override
   public String getId() {
      return id;
   }

   @Override
   public void setId(String id) {
      this.id = id;
   }

   /**
    * The date and time of the message in UTC, as recorded by the sender. The format shall be as defined for date-time
    * in [RFC 3339 section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6). It is recommended that the optional
    * time-secfrac be included up to millisecond precision
    * 
    * @param time
    *           The date and time that this request was generated.
    * @return this object.
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
   @Override
   public DateTime getTime() {
      return time;
   }

   @Override
   public void setTime(DateTime time) {
      this.time = time;
   }

   /**
    * Data relating to the originator of the request.
    *
    * @param originator
    *           The originator object describing where this payload originated from.
    * @return this object.
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
    * 
    * @param client
    *           The institution information pertaining to the client that sent this request to Electrum.
    * @return this object.
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
    * 
    * @param transactionIdentifiers
    *           A list of transaction identifiers.
    * @return this object.
    **/
   public CreateQrCodeMessage thirdPartyIdentifiers(List<ThirdPartyIdentifier> transactionIdentifiers) {
      this.thirdPartyIdentifiers = transactionIdentifiers;
      return this;
   }

   @ApiModelProperty(value = "An array of identifiers which each identify the transaction within each entity's system.")
   @JsonProperty("thirdPartyIdentifiers")
   @Valid
   @Override
   public List<ThirdPartyIdentifier> getThirdPartyIdentifiers() {
      return thirdPartyIdentifiers;
   }

   @Override
   public void setThirdPartyIdentifiers(List<ThirdPartyIdentifier> transactionIdentifiers) {
      this.thirdPartyIdentifiers = transactionIdentifiers;
   }

   /**
    * This is a reference set by the original source of the request.
    * 
    * @param rrn
    *           The retrieval reference number correlating to this transaction.
    * @return this object.
    **/
   public CreateQrCodeMessage rrn(String rrn) {
      this.rrn = rrn;
      return this;
   }

   @ApiModelProperty(required = false, value = "This is a reference set by the original source of the request.")
   @JsonProperty("rrn")
   @Override
   public String getRrn() {
      return rrn;
   }

   @Override
   public void setRrn(String rrn) {
      this.rrn = rrn;
   }

   /**
    * The System Trace Audit Number can be used to locate transactions across different systems.
    * 
    * @param stan
    *           The system trace audit number.
    * @return this object.
    **/
   public CreateQrCodeMessage stan(String stan) {
      this.stan = stan;
      return this;
   }

   @ApiModelProperty(required = false, value = "The System Trace Audit Number can be used to locate transactions across "
         + "different systems.")
   @JsonProperty("stan")
   @Override
   public String getStan() {
      return stan;
   }

   @Override
   public void setStan(String stan) {
      this.stan = stan;
   }

   /**
    * The amounts pertaining to the QR code to be created.
    * 
    * @param amounts
    *           The amounts pertaining to this qr creation request.
    * @return this object.
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

   /**
    * Information detail pertaining to the customer.
    *
    * @since v1.5.0
    *
    * @param customer
    *           instance
    * @return CreateQrCodeMessage
    */
   public CreateQrCodeMessage customer(Customer customer) {
      this.customer = customer;
      return this;
   }

   @ApiModelProperty(required = false, value = "Information detail pertaining to the customer.")
   @JsonProperty("customer")
   @Valid
   public Customer getCustomer() {
      return customer;
   }

   public void setCustomer(Customer customer) {
      this.customer = customer;
   }

   /**
    *
    * A collection of attributes that describe how a QR code is intended to be used for transacting.
    *
    * @since 1.5.0
    *
    * @param qrProperties
    *           instance
    * @return this instance of CreateQrCodeMessage
    */
   public CreateQrCodeMessage qrProperties(QrProperties qrProperties) {
      this.qrProperties = qrProperties;
      return this;
   }

   @ApiModelProperty(required = true, value = "A collection of attributes that describe how a QR code is intended to be used for transacting.")
   @JsonProperty("qrProperties")
   @Valid
   public QrProperties getQrProperties() {
      return qrProperties;
   }

   public void setQrProperties(QrProperties qrProperties) {
      this.qrProperties = qrProperties;
   }

   /**
    * The ID of the destination account to which funds will be transferred when the QR code is scanned.
    *
    * @since 1.8.0
    *
    * @param destinationAccountId
    *           The qr owner's account ID
    * @return this instance of CreateQrCodeMessage
    **/
   public CreateQrCodeMessage destinationAccountId(String destinationAccountId) {
      this.destinationAccountId = destinationAccountId;
      return this;
   }

   @JsonProperty("destinationAccountId")
   @ApiModelProperty(value = "The ID of the destination account to which funds will be transferred when the QR code is scanned.")
   @Masked
   public String getDestinationAccountId() {
      return destinationAccountId;
   }

   public void setDestinationAccountId(String destinationAccountId) {
      this.destinationAccountId = destinationAccountId;
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
            && Objects.equals(stan, request.stan) && Objects.equals(amounts, request.amounts)
            && Objects.equals(customer, request.customer) && Objects.equals(qrProperties, request.qrProperties)
            && Objects.equals(destinationAccountId, request.destinationAccountId);
   }

   @Override
   public int hashCode() {
      return Objects.hash(
            id,
            time,
            originator,
            client,
            thirdPartyIdentifiers,
            rrn,
            stan,
            amounts,
            customer,
            qrProperties,
            destinationAccountId);
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
      sb.append("    customer: ").append(Utils.toIndentedString(customer)).append(System.lineSeparator());
      sb.append("    qrProperties: ").append(Utils.toIndentedString(qrProperties)).append(System.lineSeparator());
      sb.append("    destinationAccountId: ")
            .append(Utils.toIndentedString(destinationAccountId))
            .append(System.lineSeparator());
      sb.append("}").append(System.lineSeparator());
      return sb.toString();
   }
}
