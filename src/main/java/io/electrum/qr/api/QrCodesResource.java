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

import io.electrum.qr.api.model.CreateQrCodeRequest;
import io.electrum.qr.api.model.CreateQrCodeResponse;
import io.electrum.qr.api.model.ErrorDetail;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

@Path(QrCodesResource.RESOURCE_PATH)
@Api(description = "the QR NotifyScan Service Interface API", authorizations = { @Authorization("httpBasic") })
public abstract class QrCodesResource {

   protected abstract IQrCodesResource getResourceImplementation();

   public static final String RESOURCE_PATH = "/qrCodes";
   public static final String PATH = QrApi.API_BASE_PATH + RESOURCE_PATH;

   public class CreateQrCode {
      public static final String CREATE_QR_CODE = "createQrCode";
      public static final int SUCCESS = 201;
      public static final String PATH = "/";
      public static final String RELATIVE_PATH = PATH;
      public static final String FULL_PATH = QrCodesResource.PATH + RELATIVE_PATH;
   }

   @POST
   @Path(CreateQrCode.RELATIVE_PATH)
   @Consumes({ "application/json" })
   @Produces({ "application/json" })
   @ApiOperation(nickname = CreateQrCode.CREATE_QR_CODE, value = "Request a QR Code to display to allow the initiation of a payment.", notes = "Requests a QR code to be created for display to a customer subsequently allowing a scan and payment to be effected.")
   @ApiResponses(value = {
         @ApiResponse(code = CreateQrCode.SUCCESS, message = "Created", response = CreateQrCodeResponse.class),
         @ApiResponse(code = 400, message = "Bad Request", response = ErrorDetail.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
   public final void createQrCode(
         @ApiParam(value = "A get QR code request.", required = true) @NotNull @Valid CreateQrCodeRequest body,
         @Context SecurityContext securityContext,
         @Context Request request,
         @Suspended AsyncResponse asyncResponse,
         @Context HttpHeaders httpHeaders,
         @Context UriInfo uriInfo,
         @Context HttpServletRequest httpServletRequest) {
      getResourceImplementation()
            .createQrCode(body, securityContext, request, httpHeaders, asyncResponse, uriInfo, httpServletRequest);
   }
}
