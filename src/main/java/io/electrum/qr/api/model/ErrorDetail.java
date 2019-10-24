package io.electrum.qr.api.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Describes a failed the outcome of an operation.
 **/
@ApiModel(description = "Describes a failed the outcome of an operation.")
public class ErrorDetail {

   /**
    * Every failure must be classified into one of the following failure types
    */
   public enum ErrorType {
      DUPLICATE_RECORD("DUPLICATE_RECORD"),
      FORMAT_ERROR("FORMAT_ERROR"),
      FUNCTION_NOT_SUPPORTED("FUNCTION_NOT_SUPPORTED"),
      GENERAL_ERROR("GENERAL_ERROR"),
      INVALID_AMOUNT("INVALID_AMOUNT"),
      ROUTING_ERROR("ROUTING_ERROR"),
      TRANSACTION_NOT_SUPPORTED("TRANSACTION_NOT_SUPPORTED"),
      UNABLE_TO_LOCATE_RECORD("UNABLE_TO_LOCATE_RECORD"),
      UPSTREAM_UNAVAILABLE("UPSTREAM_UNAVAILABLE"),
      ACCOUNT_ALREADY_SETTLED("ACCOUNT_ALREADY_SETTLED"),
      INVALID_MERCHANT("INVALID_MERCHANT"),
      DO_NOT_HONOR("DO_NOT_HONOR"),
      DECLINED_BY_PARTNER("DECLINED_BY_PARTNER"),
      DECLINED_BY_ACQUIRER("DECLINED_BY_ACQUIRER"),
      DECLINED_BY_ISSUER("DECLINED_BY_ISSUER"),
      INSUFFICIENT_FUNDS("INSUFFICIENT_FUNDS"),
      INVALID_CARD_NUMBER("INVALID_CARD_NUMBER"),
      CARD_EXPIRED("CARD_EXPIRED"),
      INVALID_TRAN_ID("INVALID_TRAN_ID"),
      PARTNER_UNKNOWN("PARTNER_UNKNOWN"),
      NO_SCAN_RECEIVED("NO_SCAN_RECEIVED"),
      INVALID_ACCOUNT("INVALID_ACCOUNT");

      private String value;

      ErrorType(String value) {
         this.value = value;
      }

      @Override
      @JsonValue
      public String toString() {
         return String.valueOf(value);
      }
   }

   private String id;
   private String originalId;
   private ErrorType errorType = null;
   private String errorMessage = null;
   private Object detailMessage = null;
   private String providerErrorCode = null;
   private String providerErrorMsg = null;
   private String providerRef = null;
   private String tranId = null;

   /**
    * The randomly generated UUID identifying this errorDetail, as defined for a variant 4 UUID in [RFC
    * 4122](https://tools.ietf.org/html/rfc4122).
    */
   public ErrorDetail id(String id) {
      this.id = id;
      return this;
   }

   @ApiModelProperty(required = true, value = "The randomly generated UUID identifying this errorDetail, as defined for"
         + " a variant 4 UUID in [RFC 4122](https://tools.ietf.org/html/rfc4122).")
   @JsonProperty("id")
   @NotNull
   @Length(max = 20)
   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   /**
    * The UUID of the original request message in the case of an error occurring for an advice message.
    */
   public ErrorDetail originalId(String originalId) {
      this.originalId = originalId;
      return this;
   }

   @ApiModelProperty(value = "The UUID of the original request message in the case of an error occurring for an advice message.")
   @JsonProperty("originalId")
   public String getOriginalId() {
      return originalId;
   }

   public void setOriginalId(String originalId) {
      this.originalId = originalId;
   }

   /**
    * The type of error that occurred. This value should be used for programmatic handling of errors.
    **/
   public ErrorDetail errorType(ErrorType errorType) {
      this.errorType = errorType;
      return this;
   }

   @ApiModelProperty(required = true, value = "The type of error that occurred. This value should be used for programmatic handling of errors.")
   @JsonProperty("errorType")
   @NotNull
   public ErrorType getErrorType() {
      return errorType;
   }

   public void setErrorType(ErrorType errorType) {
      this.errorType = errorType;
   }

   /**
    * A short description of the error. This value should be suitable for display to an operator.
    **/
   public ErrorDetail errorMessage(String errorMessage) {
      this.errorMessage = errorMessage;
      return this;
   }

   @ApiModelProperty(required = true, value = "A short description of the error. This value should be suitable for display to an operator.")
   @JsonProperty("errorMessage")
   @NotNull
   @Length(max = 40)
   public String getErrorMessage() {
      return errorMessage;
   }

   public void setErrorMessage(String errorMessage) {
      this.errorMessage = errorMessage;
   }

   /**
    * A free form detailed description of a particular failure condition may optionally be supplied. This information is
    * intended for informational purposes only when investigating the cause of a failure.
    **/
   public ErrorDetail detailMessage(Object detailMessage) {
      this.detailMessage = detailMessage;
      return this;
   }

   @ApiModelProperty(value = "A free form detailed description of a particular failure condition may optionally be supplied. This information is intended for informational purposes only when investigating the cause of a failure.")
   @JsonProperty("detailMessage")
   public Object getDetailMessage() {
      return detailMessage;
   }

   public void setDetailMessage(Object detailMessage) {
      this.detailMessage = detailMessage;
   }

   /**
    * The error code returned by the service provider if available. Note that this should be used for informational
    * purposes only. Messages displayed on the POS should make use of errorType and errorMessage to ensure a consistent
    * set of responses.
    **/
   public ErrorDetail providerErrorCode(String providerErrorCode) {
      this.providerErrorCode = providerErrorCode;
      return this;
   }

   @JsonProperty("providerErrorCode")
   @ApiModelProperty(value = "The error code returned by the service provider if available. Note that this should be used for informational purposes only. Messages displayed on the POS should make use of errorType and errorMessage to ensure a consistent set of responses.")
   public String getProviderErrorCode() {
      return providerErrorCode;
   }

   public void setProviderErrorCode(String providerErrorCode) {
      this.providerErrorCode = providerErrorCode;
   }

   /**
    * The error message returned by the service provider if available. Note that this should be used for informational
    * purposes only. Messages displayed on the POS should make use of errorType and errorMessage to ensure a consistent
    * set of responses.
    */
   public ErrorDetail providerErrorMsg(String providerErrorMsg) {
      this.providerErrorMsg = providerErrorMsg;
      return this;
   }

   @JsonProperty("providerErrorMsg")
   @ApiModelProperty(value = "The error message returned by the service provider if available. Note that this should be used for informational purposes only. Messages displayed on the POS should make use of errorType and errorMessage to ensure a consistent set of responses.")
   public String getProviderErrorMsg() {
      return providerErrorMsg;
   }

   public void setProviderErrorMsg(String providerErrorMessage) {
      this.providerErrorMsg = providerErrorMessage;
   }

   /**
    * The reference returned by the service provider if available.
    */
   public ErrorDetail providerRef(String providerRef) {
      this.providerRef = providerRef;
      return this;
   }

   @JsonProperty("providerRef")
   @ApiModelProperty(value = "The reference returned by the service provider if available.")
   public String getProviderRef() {
      return providerRef;
   }

   public void setProviderRef(String providerRef) {
      this.providerRef = providerRef;
   }

   /**
    * The unique transaction identifier related to this transaction if available. This is the value returned in the
    * tranId field of the CreateQrCodeResponse or the ScanNotification.
    */
   public ErrorDetail tranId(String tranId) {
      this.tranId = tranId;
      return this;
   }

   @JsonProperty("tranId")
   @ApiModelProperty(value = "The unique transaction identifier related to this transaction if available. This is the value returned in the tranId field of the CreateQrCodeResponse or the ScanNotification.")
   public String getTranId() {
      return tranId;
   }

   public void setTranId(String tranId) {
      this.tranId = tranId;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      ErrorDetail errorDetail = (ErrorDetail) o;
      return Objects.equals(errorType, errorDetail.errorType) && Objects.equals(errorMessage, errorDetail.errorMessage)
            && Objects.equals(detailMessage, errorDetail.detailMessage)
            && Objects.equals(providerErrorCode, errorDetail.providerErrorCode)
            && Objects.equals(providerErrorMsg, errorDetail.providerErrorMsg)
            && Objects.equals(providerRef, errorDetail.providerRef) && Objects.equals(tranId, errorDetail.tranId);
   }

   @Override
   public int hashCode() {
      return Objects.hash(
            id,
            originalId,
            errorType,
            errorMessage,
            detailMessage,
            providerErrorCode,
            providerErrorMsg,
            providerRef,
            tranId);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class ErrorDetail {").append(System.lineSeparator());

      sb.append("    id: ").append(Utils.toIndentedString(id)).append(System.lineSeparator());
      sb.append("    originalId: ").append(Utils.toIndentedString(originalId)).append(System.lineSeparator());
      sb.append("    errorType: ").append(Utils.toIndentedString(errorType)).append(System.lineSeparator());
      sb.append("    responseMessage: ").append(Utils.toIndentedString(errorMessage)).append(System.lineSeparator());
      sb.append("    detailMessage: ").append(Utils.toIndentedString(detailMessage)).append(System.lineSeparator());
      sb.append("    providerErrorCode: ").append(Utils.toIndentedString(providerErrorCode)).append(System.lineSeparator());
      sb.append("    providerErrorMsg: ").append(Utils.toIndentedString(providerErrorMsg)).append(System.lineSeparator());
      sb.append("    providerRef: ").append(Utils.toIndentedString(providerRef)).append(System.lineSeparator());
      sb.append("    tranId: ").append(Utils.toIndentedString(tranId)).append(System.lineSeparator());
      sb.append("}").append(System.lineSeparator());
      return sb.toString();
   }
}
