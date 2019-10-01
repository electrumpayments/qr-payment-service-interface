package io.electrum.qr.api.model.helper;

import io.electrum.vas.model.Institution;

public interface Partner {
   Institution getPartner();

   void setPartner(Institution partner);
}
