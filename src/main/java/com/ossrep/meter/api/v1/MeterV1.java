package com.ossrep.meter.api.v1;

import com.ossrep.meter.State;

public record MeterV1(
        String tdspMeterId,
        String iso,
        String tdsp,
        String addressLine1,
        String addressLine2,
        String city,
        State state,
        String zipCode
) {
}
