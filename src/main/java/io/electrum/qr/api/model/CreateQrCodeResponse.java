package io.electrum.qr.api.model;

import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.qr.api.model.helper.QrCodeField;
import io.electrum.qr.api.model.helper.TranIdField;
import io.electrum.vas.Utils;
import io.electrum.vas.model.Amounts;
import io.electrum.vas.model.Institution;
import io.electrum.vas.model.Originator;
import io.electrum.vas.model.ThirdPartyIdentifier;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The response to a CreateQrCodeRequest which contains the specific code assigned by the QR code provider as well as
 * the full QR code in EMVCo format.
 **/

@ApiModel(description = "The response to a CreateQrCodeRequest which contains the specific code assigned by the QR code provider as well as the full QR code in EMVCo format.")
public class CreateQrCodeResponse extends CreateQrCodeMessage implements TranIdField, QrCodeField {

   protected String tranId = null;
   protected String qrCode = null;

   @Override
   public CreateQrCodeResponse id(String id) {
      super.id(id);
      return this;
   }

   @Override
   public CreateQrCodeResponse time(DateTime time) {
      super.time(time);
      return this;
   }

   @Override
   public CreateQrCodeResponse originator(Originator originator) {
      super.originator(originator);
      return this;
   }

   @Override
   public CreateQrCodeResponse client(Institution client) {
      super.client(client);
      return this;
   }

   @Override
   public CreateQrCodeResponse thirdPartyIdentifiers(List<ThirdPartyIdentifier> thirdPartyIdentifiers) {
      super.thirdPartyIdentifiers(thirdPartyIdentifiers);
      return this;
   }

   @Override
   public CreateQrCodeResponse rrn(String rrn) {
      super.rrn(rrn);
      return this;
   }

   @Override
   public CreateQrCodeResponse stan(String stan) {
      super.stan(stan);
      return this;
   }

   @Override
   public CreateQrCodeResponse amounts(Amounts amounts) {
      super.amounts(amounts);
      return this;
   }

   /**
    * The unique transaction identifier assigned by the QR code provider to this QR code. This value is also encoded in
    * the QR code returned in the qrCode field. The QR code provider is responsible for ensuring appropriate uniqueness
    * of the QR code for the appropriate period of time. No specific restrictions are placed on the format of the QR
    * code (length, characters etc.) but implementors should consider the following aspects:
    * <ul>
    * <li>Length - Longer QR codes require more detailed resolution on display screens and scanning devices and are also
    * harder to scan.</li>
    * <li>Manual Entry - While manual entry of QR codes is not explicitly supported by the QR Payments Service
    * Interface, implementors may choose to support such fallback mechanisms if a QR code cannot be scanned. Longer and
    * more complicated codes will be more susceptible to errors when input manually.</li>
    * </ul>
    * This value must be provided in subsequent 'notifyScan' and 'pay' operations to link payments to specific Partners.
    **/
   public CreateQrCodeResponse tranId(String tranId) {
      this.tranId = tranId;
      return this;
   }

   @ApiModelProperty(required = true, value = "The unique transaction identifier assigned by the QR code provider to this QR code. This value is also encoded in the QR code returned in the qrCode field. The QR code provider is responsible for ensuring appropriate uniqueness of the QR code for the appropriate period of time. No specific restrictions are placed on the format of the QR code (length, characters etc.) but implementors should consider the following aspects; ***Length*** - Longer QR codes require more detailed resolution on display screens and scanning devices and are also harder to scan. ***Manual Entry*** - While manual entry of QR codes is not explicitly supported by the QR Payments Service Interface, implementors may choose to support such fallback mechanisms if a QR code cannot be scanned. Longer and more complicated codes will be more susceptible to errors when input manually. This value must be provided in subsequent 'notifyScan' and 'pay' operations to link payments to specific Partners.")
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
      return Objects.equals(tranId, request.tranId) && Objects.equals(qrCode, request.qrCode);
   }

   @Override
   public int hashCode() {
      return Objects.hash(
            super.hashCode(),
            tranId,
            qrCode);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder("class CreateQrCodeResponse{}").append(System.lineSeparator());
      sb.append("    tranId: ").append(Utils.toIndentedString(tranId)).append(System.lineSeparator());
      sb.append("    qrCode: ").append(Utils.toIndentedString(qrCode)).append(System.lineSeparator());
      sb.append("}").append(System.lineSeparator());
      sb.append(super.toString());
      return sb.toString();
   }
}
