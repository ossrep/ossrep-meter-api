package com.ossrep.service.iso;

import jakarta.validation.constraints.NotEmpty;

public record Iso(
        @NotEmpty(message = "{Iso.code.required}") String code,
        @NotEmpty(message = "{Iso.name.required}") String name
) {
}
