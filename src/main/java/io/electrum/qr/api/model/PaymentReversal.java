package io.electrum.qr.api.model;

import io.electrum.vas.Utils;
import io.electrum.vas.model.BasicReversal;
import io.swagger.annotations.ApiModel;

/**
 * Reverse a previous {@link PaymentRequest}. This may be due to a cancellation at the POS or because the original
 * {@link PaymentRequest} is in an unknown state.
 **/

@ApiModel(description = "Reverse a previous {@link PaymentRequest}. This may be due to a cancellation at the POS or because the original {@link PaymentRequest} is in an unknown state.")
public class PaymentReversal extends BasicReversal {

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class PaymentReversal {\n");

      sb.append("    id: ").append(Utils.toIndentedString(id)).append("\n");
      sb.append("    requestId: ").append(Utils.toIndentedString(requestId)).append("\n");
      sb.append("    thirdPartyIdentifiers: ").append(Utils.toIndentedString(thirdPartyIdentifiers)).append("\n");
      sb.append("    time: ").append(Utils.toIndentedString(time)).append("\n");
      sb.append("    reversalReason: ").append(Utils.toIndentedString(reversalReason)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
