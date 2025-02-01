package com.ossrep.api;

import java.util.List;

public record ErrorResponse(
        String errorId,
        List<ErrorMessage> errorMessages
) {

    public ErrorResponse(List<ErrorMessage> errorMessages) {
        this(null, errorMessages);
    }

    public ErrorResponse(String errorId, ErrorMessage errorMessage) {
        this(errorId, List.of(errorMessage));
    }

    public ErrorResponse(ErrorMessage errorMessage) {
        this(null, List.of(errorMessage));
    }

}
