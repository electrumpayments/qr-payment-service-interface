package io.electrum.qr.api.model;

import io.electrum.vas.Utils;
import io.electrum.vas.model.BasicAdvice;
import io.swagger.annotations.ApiModel;

/**
 * Confirm that a previous {@link PaymentRequest} has completed successfully at the POS.
 **/

@ApiModel(description = "Confirm that a previous {@link PaymentRequest} has completed successfully at the POS.")
public class PaymentConfirmation extends BasicAdvice {

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class PaymentConfirmation {\n");

      sb.append("    id: ").append(Utils.toIndentedString(id)).append("\n");
      sb.append("    requestId: ").append(Utils.toIndentedString(requestId)).append("\n");
      sb.append("    thirdPartyIdentifiers: ").append(Utils.toIndentedString(thirdPartyIdentifiers)).append("\n");
      sb.append("    time: ").append(Utils.toIndentedString(time)).append("\n");
      sb.append("    rrn: ").append(Utils.toIndentedString(rrn)).append("\n");
      sb.append("    stan: ").append(Utils.toIndentedString(stan)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
