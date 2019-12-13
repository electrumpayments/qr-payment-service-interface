package io.electrum.qr.api;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.electrum.qr.api.model.CreateQrCodeRequest;
import io.electrum.qr.api.model.CreateQrCodeResponse;
import io.electrum.qr.api.model.ScanNotification;
import io.electrum.vas.JsonUtil;

public class ModelsTest {

   @BeforeClass
   public void beforeClass() {
   }

   @BeforeMethod
   public void beforeMethod() {
   }

   @Test
   public void testCreateQrCodeRequestHashcode() throws IOException {
      CreateQrCodeRequest createQrCodeReq1 = JsonUtil.deserialize("{}", CreateQrCodeRequest.class);
      CreateQrCodeRequest createQrCodeReq2 = JsonUtil.deserialize("{}", CreateQrCodeRequest.class);
      Assert.assertEquals(createQrCodeReq1.hashCode(), createQrCodeReq2.hashCode());
   }

   @Test
   public void testCreateQrCodeResponseHashcode() throws IOException {
      CreateQrCodeResponse createQrCodeRsp1 = JsonUtil.deserialize("{}", CreateQrCodeResponse.class);
      CreateQrCodeResponse createQrCodeRsp2 = JsonUtil.deserialize("{}", CreateQrCodeResponse.class);
      Assert.assertEquals(createQrCodeRsp1.hashCode(), createQrCodeRsp2.hashCode());
   }

   @Test
   public void testScanNotificationHashcode() throws IOException {
      ScanNotification scanNotification1 = JsonUtil.deserialize("{}", ScanNotification.class);
      ScanNotification scanNotification2 = JsonUtil.deserialize("{}", ScanNotification.class);
      Assert.assertEquals(scanNotification1.hashCode(), scanNotification2.hashCode());
   }
}
