package com.ossrep.api.meter;

import com.ossrep.api.Role;
import com.ossrep.service.meter.Meter;
import com.ossrep.service.meter.MeterService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.net.URI;

@Path("/api/v1/meters")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "meter", description = "Meter Operations")
public class MeterResourceV1 {

    private final MeterService meterService;

    public MeterResourceV1(MeterService meterService) {
        this.meterService = meterService;
    }

    @GET
    @Path("/{tdspMeterId}")
    @APIResponse(responseCode = "200", description = "Get Meter by tdspMeterId",
            content = @Content(schema = @Schema(implementation = MeterV1.class))
    )
    @APIResponse(responseCode = "404", description = "Meter does not exist for tdspMeterId")
    @RolesAllowed(Role.METER_READ)
    public Response getById(@Parameter(name = "tdspMeterId", required = true) @PathParam("tdspMeterId") String tdspMeterId) {
        return meterService.findByTdspMeterId(tdspMeterId)
                .map(meter -> Response.ok(meterMapper(meter)).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @POST
    @APIResponse(responseCode = "201", description = "Meter Created",
            content = @Content(schema = @Schema(implementation = MeterV1.class))
    )
    @APIResponse(responseCode = "400", description = "Invalid Meter")
    @RolesAllowed(Role.METER_WRITE)
    public Response post(@NotNull @Valid MeterV1 meterV1, @Context UriInfo uriInfo) {
        Meter meter = toMeter(meterV1);
        meterService.save(meter);
        URI uri = uriInfo.getAbsolutePathBuilder().path(meter.tdspMeterId()).build();
        return Response.created(uri).entity(meterV1).build();
    }

    private MeterV1 meterMapper(Meter meter) {
        return new MeterV1(meter.tdspCode(), meter.tdspMeterId());
    }

    private Meter toMeter(MeterV1 meter) {
        return new Meter(meter.tdspCode(), meter.tdspMeterId());
    }

}
