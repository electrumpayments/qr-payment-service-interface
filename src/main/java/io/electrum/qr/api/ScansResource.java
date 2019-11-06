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
import io.electrum.qr.api.model.ScanNotification;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

@Path(ScansResource.RESOURCE_PATH)
@Api(authorizations = { @Authorization("httpBasic") })
public abstract class ScansResource {

   protected abstract IScansResource getResourceImplementation();

   public static final String RESOURCE_PATH = "/scans";
   public static final String PATH = QrApi.API_BASE_PATH + RESOURCE_PATH;

   public class NotifyScan {
      public static final String NOTIFY_SCAN = "notifyScan";
      public static final int SUCCESS = 202;
      public static final String PATH = "/";
      public static final String RELATIVE_PATH = PATH;
      public static final String FULL_PATH = ScansResource.PATH + RELATIVE_PATH;
   }

   @POST
   @Path(NotifyScan.RELATIVE_PATH)
   @Consumes({ "application/json" })
   @Produces({ "application/json" })
   @ApiOperation(nickname = NotifyScan.NOTIFY_SCAN, value = "Notify that a QR code has been scanned.", notes = "Partners are not "
         + "notified by a QR code provider when a QR code is generated. Only when a consumer scans a QR code using a Partner's "
         + "application is the Partner aware that the QR code is available. The Partner subsequently informs the provider of "
         + "the QR code that their code has been scanned. The QR code provider shall then associate any other transactions "
         + "pertaining to the QR code with the Partner.")
   @ApiResponses(value = { @ApiResponse(code = NotifyScan.SUCCESS, message = "Accepted"),
         @ApiResponse(code = 400, message = "Bad Request", response = ErrorDetail.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
   public final void notifyScan(
         @ApiParam(value = "A get QR code request.", required = true) @NotNull @Valid ScanNotification body,
         @Context SecurityContext securityContext,
         @Context Request request,
         @Suspended AsyncResponse asyncResponse,
         @Context HttpHeaders httpHeaders,
         @Context UriInfo uriInfo,
         @Context HttpServletRequest httpServletRequest) {
      getResourceImplementation()
            .notifyScan(body, securityContext, request, httpHeaders, asyncResponse, uriInfo, httpServletRequest);
   }
}
