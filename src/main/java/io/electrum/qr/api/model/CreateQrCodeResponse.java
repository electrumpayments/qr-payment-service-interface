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
 * A notification sent by the partner indicating that the partner received a scan of the QR code linked to the
 * transaction ID.
 **/

@ApiModel(description = "A request to effect a payment with a linked QR code scan.")
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
