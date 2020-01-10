package io.electrum.qr.api;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.electrum.qr.api.model.CreateQrCodeRequest;
import io.electrum.qr.api.model.CreateQrCodeResponse;
import io.electrum.qr.api.model.ErrorDetail;
import io.electrum.qr.api.model.PaymentConfirmation;
import io.electrum.qr.api.model.PaymentRequest;
import io.electrum.qr.api.model.PaymentResponse;
import io.electrum.qr.api.model.PaymentReversal;
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
   public void testCreateQrCodeRequest() throws IOException {
      CreateQrCodeRequest createQrCodeReq1 = JsonUtil.deserialize("{}", CreateQrCodeRequest.class);
      CreateQrCodeRequest createQrCodeReq2 = JsonUtil.deserialize("{}", CreateQrCodeRequest.class);
      Assert.assertEquals(createQrCodeReq1.hashCode(), createQrCodeReq2.hashCode());
      Assert.assertEquals(createQrCodeReq1, createQrCodeReq2);
   }

   @Test
   public void testCreateQrCodeResponse() throws IOException {
      CreateQrCodeResponse createQrCodeRsp1 = JsonUtil.deserialize("{}", CreateQrCodeResponse.class);
      CreateQrCodeResponse createQrCodeRsp2 = JsonUtil.deserialize("{}", CreateQrCodeResponse.class);
      Assert.assertEquals(createQrCodeRsp1.hashCode(), createQrCodeRsp2.hashCode());
      Assert.assertEquals(createQrCodeRsp1, createQrCodeRsp2);
   }

   @Test
   public void testScanNotification() throws IOException {
      ScanNotification scanNotification1 = JsonUtil.deserialize("{}", ScanNotification.class);
      ScanNotification scanNotification2 = JsonUtil.deserialize("{}", ScanNotification.class);
      Assert.assertEquals(scanNotification1.hashCode(), scanNotification2.hashCode());
      Assert.assertEquals(scanNotification1, scanNotification2);
   }

   @Test
   public void testPaymentRequest() throws IOException {
      PaymentRequest paymentRequest1 = JsonUtil.deserialize("{}", PaymentRequest.class);
      PaymentRequest paymentRequest2 = JsonUtil.deserialize("{}", PaymentRequest.class);
      Assert.assertEquals(paymentRequest1.hashCode(), paymentRequest2.hashCode());
      Assert.assertEquals(paymentRequest1, paymentRequest2);
   }

   @Test
   public void testPaymentResponse() throws IOException {
      PaymentResponse paymentResponse1 = JsonUtil.deserialize("{}", PaymentResponse.class);
      PaymentResponse paymentResponse2 = JsonUtil.deserialize("{}", PaymentResponse.class);
      Assert.assertEquals(paymentResponse1.hashCode(), paymentResponse2.hashCode());
      Assert.assertEquals(paymentResponse1, paymentResponse2);
   }

   @Test
   public void testPaymentReversal() throws IOException {
      PaymentReversal paymentReversal1 = JsonUtil.deserialize("{}", PaymentReversal.class);
      PaymentReversal paymentReversal2 = JsonUtil.deserialize("{}", PaymentReversal.class);
      Assert.assertEquals(paymentReversal1.hashCode(), paymentReversal2.hashCode());
      Assert.assertEquals(paymentReversal1, paymentReversal2);
   }

   @Test
   public void testPaymentConfirmation() throws IOException {
      PaymentConfirmation paymentConfirmation1 = JsonUtil.deserialize("{}", PaymentConfirmation.class);
      PaymentConfirmation paymentConfirmation2 = JsonUtil.deserialize("{}", PaymentConfirmation.class);
      Assert.assertEquals(paymentConfirmation1.hashCode(), paymentConfirmation2.hashCode());
      Assert.assertEquals(paymentConfirmation1, paymentConfirmation2);
   }

   @Test
   public void testErrorDetail() throws IOException {
      ErrorDetail errorDetail1 = JsonUtil.deserialize("{}", ErrorDetail.class);
      ErrorDetail errorDetail2 = JsonUtil.deserialize("{}", ErrorDetail.class);
      Assert.assertEquals(errorDetail1.hashCode(), errorDetail2.hashCode());
      Assert.assertEquals(errorDetail1, errorDetail2);
   }
}
