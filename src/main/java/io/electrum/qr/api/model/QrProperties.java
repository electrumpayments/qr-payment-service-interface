package io.electrum.qr.api.model;

import java.time.OffsetDateTime;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A collection of attributes that describe how a QR code is intended to be used for transacting.
 *
 * @since 1.5.0
 */
@ApiModel(description = "A collection of attributes that describe how a QR code is intended to be used for transacting.")
public class QrProperties {

   @JsonProperty("description")
   private String description = null;

   @JsonProperty("guid")
   private String guid = null;

   @JsonProperty("partPaymentAllowed")
   private Boolean partPaymentAllowed = null;

   @JsonProperty("expiryDate")
   private OffsetDateTime expiryDate = null;

   public QrProperties description(String description) {
      this.description = description;
      return this;
   }

   /**
    * A short description for the QR code defining why it was created.
    * 
    * @return description
    **/
   @JsonProperty("description")
   @ApiModelProperty(value = "A short description for the QR code defining why it was created.")
   @Size(min = 0, max = 20)
   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public QrProperties guid(String guid) {
      this.guid = guid;
      return this;
   }

   /**
    * The value which, when embedded in an EMVCo QR code, identifies the provider of the QR code.
    *
    * @return guid
    **/
   @JsonProperty("guid")
   @ApiModelProperty(value = "The value which, when embedded in an EMVCo QR code, identifies the provider of the QR code.")
   public String getGuid() {
      return guid;
   }

   public void setGuid(String guid) {
      this.guid = guid;
   }

   public QrProperties partPaymentAllowed(Boolean partPaymentAllowed) {
      this.partPaymentAllowed = partPaymentAllowed;
      return this;
   }

   /**
    * Indicates whether or not the transaction against the QR may use an amount less than the value in the
    * &#x60;amount&#x60; field.
    *
    * @return partPaymentAllowed
    **/
   @JsonProperty("partPaymentAllowed")
   @ApiModelProperty(value = "Indicates whether or not the transaction against the QR may use an amount less than the value in the `amount` field.")
   public Boolean isPartPaymentAllowed() {
      return partPaymentAllowed;
   }

   public void setPartPaymentAllowed(Boolean partPaymentAllowed) {
      this.partPaymentAllowed = partPaymentAllowed;
   }

   public QrProperties expiryDate(OffsetDateTime expiryDate) {
      this.expiryDate = expiryDate;
      return this;
   }

   /**
    * The date and time at which the QR code expires at which point it may no longer be used to facilitate transactions.
    * The format shall be as defined for date-time in [RFC 3339 section
    * 5.6](https://tools.ietf.org/html/rfc3339#section-5.6). It is recommended that the optional time-secfrac be
    * included up to millisecond precision
    *
    * @return expiryDate
    **/
   @JsonProperty("expiryDate")
   @ApiModelProperty(value = "The date and time at which the QR code expires at which point it may no longer be used to facilitate transactions. The format shall be as defined for date-time in [RFC 3339 section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6). It is recommended that the optional time-secfrac be included up to millisecond precision")
   @Valid
   public OffsetDateTime getExpiryDate() {
      return expiryDate;
   }

   public void setExpiryDate(OffsetDateTime expiryDate) {
      this.expiryDate = expiryDate;
   }

   @Override
   public boolean equals(java.lang.Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      QrProperties qrProperties = (QrProperties) o;
      return Objects.equals(this.description, qrProperties.description) && Objects.equals(this.guid, qrProperties.guid)
            && Objects.equals(this.partPaymentAllowed, qrProperties.partPaymentAllowed)
            && Objects.equals(this.expiryDate, qrProperties.expiryDate);
   }

   @Override
   public int hashCode() {
      return Objects.hash(description, guid, partPaymentAllowed, expiryDate);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class QrProperties {\n");

      sb.append("    description: ").append(toIndentedString(description)).append("\n");
      sb.append("    guid: ").append(toIndentedString(guid)).append("\n");
      sb.append("    partPaymentAllowed: ").append(toIndentedString(partPaymentAllowed)).append("\n");
      sb.append("    expiryDate: ").append(toIndentedString(expiryDate)).append("\n");
      sb.append("}");
      return sb.toString();
   }

   /**
    * Convert the given object to string with each line indented by 4 spaces (except the first line).
    */
   private String toIndentedString(java.lang.Object o) {
      if (o == null) {
         return "null";
      }
      return o.toString().replace("\n", "\n    ");
   }
}
