package com.ossrep.meter.api.v1;

import com.ossrep.meter.meter.MeterService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.Optional;

@Path("/api/v1/meters")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "meter", description = "Meter Operations")
public class MeterResourceV1 {

    private final MeterService meterService;
    private final ApiMapper apiMapper;

    public MeterResourceV1(MeterService meterService, ApiMapper apiMapper) {
        this.meterService = meterService;
        this.apiMapper = apiMapper;
    }

    @GET
    @Path("/{tdspMeterId}")
    @APIResponse(responseCode = "200", description = "Get Meter by tdspMeterId",
            content = @Content(schema = @Schema(implementation = MeterV1.class))
    )
    @APIResponse(responseCode = "404", description = "Meter does not exist for tdspMeterId")
    public Response getByTdspMeterId(@Parameter(name = "tdspMeterId", required = true) @PathParam("tdspMeterId") String tdspMeterId) {
        Optional<MeterV1> optionalMeter = meterService.findByTdspMeterId(tdspMeterId).map(apiMapper::toApi);
        return optionalMeter.isPresent() ? Response.ok(optionalMeter.get()).build() : Response.status(Response.Status.NOT_FOUND).build();
    }

}
