package io.electrum.qr.api.model;

import java.util.List;

import io.electrum.vas.model.Customer;
import org.joda.time.DateTime;

import io.electrum.vas.model.Amounts;
import io.electrum.vas.model.Institution;
import io.electrum.vas.model.Originator;
import io.electrum.vas.model.ThirdPartyIdentifier;
import io.swagger.annotations.ApiModel;

/**
 * A request from the merchant for a QR code to be generated. The QR code returned should be suitable to be displayed to
 * a consumer to be scanned.
 **/

@ApiModel(description = "A request from the merchant for a QR code to be generated. The QR code returned should be suitable "
      + "to be displayed to a consumer to be scanned.")
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
   public CreateQrCodeRequest customer(Customer customer) {
      super.customer(customer);
      return this;
   }

   @Override
   public CreateQrCodeRequest qrProperties(QrProperties qrProperties) {
      super.qrProperties(qrProperties);
      return this;
   }

   @Override
   public String toString() {
      StringBuilder sb =
            new StringBuilder("class CreateQrCodeRequest {}").append(System.lineSeparator()).append(super.toString());
      return sb.toString();
   }
}
