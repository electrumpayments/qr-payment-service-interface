package io.electrum.qr.api;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

import io.electrum.qr.api.model.ErrorDetail;
import io.electrum.qr.api.model.PaymentConfirmation;
import io.electrum.qr.api.model.PaymentRequest;
import io.electrum.qr.api.model.PaymentResponse;
import io.electrum.qr.api.model.PaymentReversal;
import io.electrum.vas.model.BasicAdvice;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

@Path(PaymentResource.RESOURCE_PATH)
@Api(description = "the QR NotifyScan Service Interface API", authorizations = { @Authorization("httpBasic") })
public abstract class PaymentResource {

   protected abstract IPaymentResource getResourceImplementation();

   public static final String RESOURCE_PATH = "/payments";
   public static final String PATH = QrApi.API_BASE_PATH + RESOURCE_PATH;

   public class ConfirmPayment {
      public static final String PAYMENT_CONFIRMATION = "confirmPayment";
      public static final int SUCCESS = 202;
      public static final String PATH = "/confirmations";
      public static final String RELATIVE_PATH = PATH;
      public static final String FULL_PATH = PaymentResource.PATH + RELATIVE_PATH;
   }

   public class Pay {
      public static final String PAY = "pay";
      public static final int SUCCESS = 201;
      public static final String PATH = "/";
      public static final String RELATIVE_PATH = PATH;
      public static final String FULL_PATH = PaymentResource.PATH + RELATIVE_PATH;
   }

   public class ReversePayment {
      public static final String REVERSE_PAYMENT = "reversePayment";
      public static final int SUCCESS = 202;
      public static final String PATH = "/reversals";
      public static final String RELATIVE_PATH = PATH;
      public static final String FULL_PATH = PaymentResource.PATH + RELATIVE_PATH;
   }

   @POST
   @Path(ConfirmPayment.RELATIVE_PATH)
   @Consumes({ "application/json" })
   @Produces({ "application/json" })
   @ApiOperation(nickname = ConfirmPayment.PAYMENT_CONFIRMATION, value = "Confirm completion of tender initiated by a payment request.", notes = "Confirm that the payment previously authorised has now been completed by the merchant and the customer has their goods.")
   @ApiResponses(value = {
         @ApiResponse(code = ConfirmPayment.SUCCESS, message = "Accepted", response = BasicAdvice.class),
         @ApiResponse(code = 400, message = "Bad Request", response = ErrorDetail.class),
         @ApiResponse(code = 404, message = "Not Found", response = ErrorDetail.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
   public final void confirmPayment(
         @ApiParam(value = "A QR payment confirmation.", required = true) @NotNull @Valid PaymentConfirmation body,
         @Context SecurityContext securityContext,
         @Context Request request,
         @Suspended AsyncResponse asyncResponse,
         @Context HttpHeaders httpHeaders,
         @Context UriInfo uriInfo,
         @Context HttpServletRequest httpServletRequest) {
      getResourceImplementation()
            .confirmPayment(body, securityContext, request, httpHeaders, asyncResponse, uriInfo, httpServletRequest);
   }

   @POST
   @Path(Pay.RELATIVE_PATH)
   @Consumes({ "application/json" })
   @Produces({ "application/json" })
   @ApiOperation(nickname = Pay.PAY, value = "Tender via QR code.", notes = "A request to tender via QR code has been made by a customer and subsequently a QR code was issued and displayed by the merchant. This operation requests a payment be authorised by the partner and linked to said QR code.")
   @ApiResponses(value = { @ApiResponse(code = Pay.SUCCESS, message = "Created", response = PaymentResponse.class),
         @ApiResponse(code = 400, message = "Bad Request", response = ErrorDetail.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
   public final void pay(
         @ApiParam(value = "A QR payment request.", required = true) @NotNull @Valid PaymentRequest body,
         @Context SecurityContext securityContext,
         @Context Request request,
         @Suspended AsyncResponse asyncResponse,
         @Context HttpHeaders httpHeaders,
         @Context UriInfo uriInfo,
         @Context HttpServletRequest httpServletRequest) {
      getResourceImplementation()
            .pay(body, securityContext, request, httpHeaders, asyncResponse, uriInfo, httpServletRequest);
   }

   @POST
   @Path(ReversePayment.RELATIVE_PATH)
   @Consumes({ "application/json" })
   @Produces({ "application/json" })
   @ApiOperation(nickname = ReversePayment.REVERSE_PAYMENT, value = "Reverse a payment request that failed or timed out", notes = "Reverse a previously requested payment. The sale did not complete and the payment should be reversed.")
   @ApiResponses(value = {
         @ApiResponse(code = ReversePayment.SUCCESS, message = "Accepted", response = PaymentReversal.class),
         @ApiResponse(code = 400, message = "Bad Request", response = ErrorDetail.class),
         @ApiResponse(code = 404, message = "Not Found"),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
   public final void reversePayment(
         @ApiParam(value = "A QR payment reversal.", required = true) @NotNull @Valid PaymentReversal body,
         @Context SecurityContext securityContext,
         @Context Request request,
         @Suspended AsyncResponse asyncResponse,
         @Context HttpHeaders httpHeaders,
         @Context UriInfo uriInfo,
         @Context HttpServletRequest httpServletRequest) {
      getResourceImplementation()
            .reversePayment(body, securityContext, request, httpHeaders, asyncResponse, uriInfo, httpServletRequest);
   }
}
