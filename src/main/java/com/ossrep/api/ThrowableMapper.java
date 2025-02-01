package com.ossrep.api;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

@Provider
public class ThrowableMapper implements ExceptionMapper<Throwable> {

    private final static Logger LOGGER = LoggerFactory.getLogger(ThrowableMapper.class);

    @Override
    public Response toResponse(Throwable e) {
        String errorId = UUID.randomUUID().toString();
        String defaultErrorMessage = this.getDefaultErrorMessage();
        ErrorMessage errorMessage = new ErrorMessage(null, defaultErrorMessage);
        ErrorResponse errorResponse = new ErrorResponse(errorId, errorMessage);
        LOGGER.error("{}", errorResponse, e);
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorResponse).build();
    }

    private String getDefaultErrorMessage() {
        return "An unexpected system error has occurred";
    }

}
