package io.electrum.qr.api.model;

import java.time.OffsetDateTime;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.electrum.vas.model.LedgerAmount;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import javax.validation.Valid;

/**
 * A collection of attributes that describe how a QR code is intended to be used for transacting.
 *
 * @since 1.5.0
 */
@ApiModel(description = "A collection of attributes that describe how a QR code is intended to be used for transacting.")
public class QrProperties   {
   @JsonProperty("uuid")
   private String uuid = null;

   @JsonProperty("value")
   private LedgerAmount value = null;

   @JsonProperty("overPaymentAllowed")
   private Boolean overPaymentAllowed = null;

   @JsonProperty("partPaymentAllowed")
   private Boolean partPaymentAllowed = null;

   @JsonProperty("expiryDate")
   private OffsetDateTime expiryDate = null;

   @JsonProperty("singleUse")
   private Boolean singleUse = null;

   /**
    * The scheme which defines the format of the contents of the &#x60;qrData&#x60; field of a &#x60;qrCode&#x60; object. Allowed values are described below with a brief description. Please consult Electrum for further detail.:   * EMVCO_MERCHANT - The EMVCo merchant-presented QR code format.   * PSEUDO_EMVCO_MERCHANT - A format based on the EMVCo merchant-presented QR code format however fields which are manadatory in the EMVCo specification may be absent in this scheme.   * ELECTRUM_MERCHANT_MINIMAL - A format which is based on the EMVCo merchant-presented QR code specification however it comprises the minimal set of fields to faciliate transactions.
    */
   public enum SchemeEnum {
      EMVCO_MERCHANT("EMVCO_MERCHANT"),

      PSEUDO_EMVCO_MERCHANT("PSEUDO_EMVCO_MERCHANT"),

      ELECTRUM_MERCHANT_MINIMAL("ELECTRUM_MERCHANT_MINIMAL");

      private String value;

      SchemeEnum(String value) {
         this.value = value;
      }

      @Override
      @JsonValue
      public String toString() {
         return String.valueOf(value);
      }

      @JsonCreator
      public static SchemeEnum fromValue(String text) {
         for (SchemeEnum b : SchemeEnum.values()) {
            if (String.valueOf(b.value).equals(text)) {
               return b;
            }
         }
         return null;
      }
   }
   @JsonProperty("scheme")
   private SchemeEnum scheme = null;

   public QrProperties uuid(String uuid) {
      this.uuid = uuid;
      return this;
   }

   /**
    * The value which, when embedded in an EMVCo QR code, identifies that Capitec is the provider of the QR code.
    * @return uuid
    **/
   @JsonProperty("uuid")
   @ApiModelProperty(value = "The value which, when embedded in an EMVCo QR code, identifies that Capitec is the provider of the QR code.")
   public String getUuid() {
      return uuid;
   }

   public void setUuid(String uuid) {
      this.uuid = uuid;
   }

   public QrProperties value(LedgerAmount value) {
      this.value = value;
      return this;
   }

   /**
    * Get value
    * @return value
    **/
   @JsonProperty("value")
   @ApiModelProperty(value = "")
   @Valid
   public LedgerAmount getValue() {
      return value;
   }

   public void setValue(LedgerAmount value) {
      this.value = value;
   }

   public QrProperties overPaymentAllowed(Boolean overPaymentAllowed) {
      this.overPaymentAllowed = overPaymentAllowed;
      return this;
   }

   /**
    * Indicates whether or not the transaction against the QR may use an amount greater than the value in the &#x60;amount&#x60; field.
    * @return overPaymentAllowed
    **/
   @JsonProperty("overPaymentAllowed")
   @ApiModelProperty(value = "Indicates whether or not the transaction against the QR may use an amount greater than the value in the `amount` field.")
   public Boolean isOverPaymentAllowed() {
      return overPaymentAllowed;
   }

   public void setOverPaymentAllowed(Boolean overPaymentAllowed) {
      this.overPaymentAllowed = overPaymentAllowed;
   }

   public QrProperties partPaymentAllowed(Boolean partPaymentAllowed) {
      this.partPaymentAllowed = partPaymentAllowed;
      return this;
   }

   /**
    * Indicates whether or not the transaction against the QR may use an amount less than the value in the &#x60;amount&#x60; field.
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
    * The date and time at which the QR code expires at which point it may no longer be used to facilitate transactions. The format shall be as defined for date-time in [RFC 3339 section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6). It is recommended that the optional time-secfrac be included up to millisecond precision
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

   public QrProperties singleUse(Boolean singleUse) {
      this.singleUse = singleUse;
      return this;
   }

   /**
    * If set to &#x60;true&#x60;, the QR code is intended to be used for a single transaction only. *Note*: This is not a strictly enforced rule but is rather intended as a guide as to the intended use of the QR code.
    * @return singleUse
    **/
   @JsonProperty("singleUse")
   @ApiModelProperty(value = "If set to `true`, the QR code is intended to be used for a single transaction only. *Note*: This is not a strictly enforced rule but is rather intended as a guide as to the intended use of the QR code.")
   public Boolean isSingleUse() {
      return singleUse;
   }

   public void setSingleUse(Boolean singleUse) {
      this.singleUse = singleUse;
   }

   public QrProperties scheme(SchemeEnum scheme) {
      this.scheme = scheme;
      return this;
   }

   /**
    * The scheme which defines the format of the contents of the &#x60;qrData&#x60; field of a &#x60;qrCode&#x60; object. Allowed values are described below with a brief description. Please consult Electrum for further detail.:   * EMVCO_MERCHANT - The EMVCo merchant-presented QR code format.   * PSEUDO_EMVCO_MERCHANT - A format based on the EMVCo merchant-presented QR code format however fields which are manadatory in the EMVCo specification may be absent in this scheme.   * ELECTRUM_MERCHANT_MINIMAL - A format which is based on the EMVCo merchant-presented QR code specification however it comprises the minimal set of fields to faciliate transactions.
    * @return scheme
    **/
   @JsonProperty("scheme")
   @ApiModelProperty(value = "The scheme which defines the format of the contents of the `qrData` field of a `qrCode` object. Allowed values are described below with a brief description. Please consult Electrum for further detail.:   * EMVCO_MERCHANT - The EMVCo merchant-presented QR code format.   * PSEUDO_EMVCO_MERCHANT - A format based on the EMVCo merchant-presented QR code format however fields which are manadatory in the EMVCo specification may be absent in this scheme.   * ELECTRUM_MERCHANT_MINIMAL - A format which is based on the EMVCo merchant-presented QR code specification however it comprises the minimal set of fields to faciliate transactions. ")
   public SchemeEnum getScheme() {
      return scheme;
   }

   public void setScheme(SchemeEnum scheme) {
      this.scheme = scheme;
   }


   @Override
   public boolean equals(java.lang.Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      QrProperties QrProperties = (QrProperties) o;
      return Objects.equals(this.uuid, QrProperties.uuid) &&
            Objects.equals(this.value, QrProperties.value) &&
            Objects.equals(this.overPaymentAllowed, QrProperties.overPaymentAllowed) &&
            Objects.equals(this.partPaymentAllowed, QrProperties.partPaymentAllowed) &&
            Objects.equals(this.expiryDate, QrProperties.expiryDate) &&
            Objects.equals(this.singleUse, QrProperties.singleUse) &&
            Objects.equals(this.scheme, QrProperties.scheme);
   }

   @Override
   public int hashCode() {
      return Objects.hash(uuid, value, overPaymentAllowed, partPaymentAllowed, expiryDate, singleUse, scheme);
   }


   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class QrProperties {\n");

      sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
      sb.append("    value: ").append(toIndentedString(value)).append("\n");
      sb.append("    overPaymentAllowed: ").append(toIndentedString(overPaymentAllowed)).append("\n");
      sb.append("    partPaymentAllowed: ").append(toIndentedString(partPaymentAllowed)).append("\n");
      sb.append("    expiryDate: ").append(toIndentedString(expiryDate)).append("\n");
      sb.append("    singleUse: ").append(toIndentedString(singleUse)).append("\n");
      sb.append("    scheme: ").append(toIndentedString(scheme)).append("\n");
      sb.append("}");
      return sb.toString();
   }

   /**
    * Convert the given object to string with each line indented by 4 spaces
    * (except the first line).
    */
   private String toIndentedString(java.lang.Object o) {
      if (o == null) {
         return "null";
      }
      return o.toString().replace("\n", "\n    ");
   }
}
