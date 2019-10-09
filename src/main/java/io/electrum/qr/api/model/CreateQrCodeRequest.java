package io.electrum.qr.api.model;

import java.util.List;
import java.util.Objects;

import org.joda.time.DateTime;

import io.electrum.vas.Utils;
import io.electrum.vas.model.Amounts;
import io.electrum.vas.model.Institution;
import io.electrum.vas.model.Originator;
import io.electrum.vas.model.ThirdPartyIdentifier;
import io.swagger.annotations.ApiModel;

/**
 * A request from the merchant for a QR code to be generated and returned to the merchant to display to the customer for
 * the customer to scan.
 **/

@ApiModel(description = "A request to effect a payment with a linked QR code scan.")
public class CreateQrCodeRequest extends CreateQrCodeMessage {

   @Override
   public CreateQrCodeRequest id(String id) {
      super.id(id);
      return this;
   }

   @Override
   public CreateQrCodeRequest time(DateTime time) {
      super.time(time);
      return this;
   }

   @Override
   public CreateQrCodeRequest originator(Originator originator) {
      super.originator(originator);
      return this;
   }

   @Override
   public CreateQrCodeRequest client(Institution client) {
      super.client(client);
      return this;
   }

   @Override
   public CreateQrCodeRequest thirdPartyIdentifiers(List<ThirdPartyIdentifier> thirdPartyIdentifiers) {
      super.thirdPartyIdentifiers(thirdPartyIdentifiers);
      return this;
   }

   @Override
   public CreateQrCodeRequest rrn(String rrn) {
      super.rrn(rrn);
      return this;
   }

   @Override
   public CreateQrCodeRequest stan(String stan) {
      super.stan(stan);
      return this;
   }

   @Override
   public CreateQrCodeRequest amounts(Amounts amounts) {
      super.amounts(amounts);
      return this;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o)
         return true;
      if (o == null || getClass() != o.getClass())
         return false;
      if (!super.equals(o))
         return false;
      CreateQrCodeRequest request = (CreateQrCodeRequest) o;
      return Objects.equals(id, request.id) && Objects.equals(time, request.time)
            && Objects.equals(originator, request.originator) && Objects.equals(client, request.client)
            && Objects.equals(thirdPartyIdentifiers, request.thirdPartyIdentifiers) && Objects.equals(rrn, request.rrn)
            && Objects.equals(stan, request.stan) && Objects.equals(amounts, request.amounts);
   }

   @Override
   public int hashCode() {
      return Objects.hash(super.hashCode(), id, time, originator, client, thirdPartyIdentifiers, rrn, stan, amounts);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class CreateQrCodeRequest {\n");

      sb.append("    id: ").append(Utils.toIndentedString(id)).append("\n");
      sb.append("    time: ").append(Utils.toIndentedString(time)).append("\n");
      sb.append("    originator: ").append(Utils.toIndentedString(originator)).append("\n");
      sb.append("    client: ").append(Utils.toIndentedString(client)).append("\n");
      sb.append("    thirdPartyIdentifiers: ").append(Utils.toIndentedString(thirdPartyIdentifiers)).append("\n");
      sb.append("    rrn: ").append(Utils.toIndentedString(rrn)).append("\n");
      sb.append("    stan: ").append(Utils.toIndentedString(stan)).append("\n");
      sb.append("    amounts: ").append(Utils.toIndentedString(amounts)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
