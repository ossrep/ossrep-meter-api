package com.ossrep.meter.api.v1;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/api/v1/meters")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "meter", description = "Meter Operations")
public class MeterResourceV1 {

    @GET
    @Path("/{meterId}")
    @APIResponse(responseCode = "200", description = "Get Meter by meterId",
            content = @Content(schema = @Schema(implementation = MeterV1.class))
    )
    @APIResponse(responseCode = "404", description = "Meter does not exist for meterId")
    public Response getById(@Parameter(name = "meterId", required = true) @PathParam("meterId") String meterId) {
        return Response.ok(new MeterV1(meterId)).build();
    }

}
