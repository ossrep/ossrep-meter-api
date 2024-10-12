package com.ossrep.meter.meter;

import com.ossrep.meter.State;
import com.ossrep.meter.tdsp.Tdsp;

public record Meter(Long meterId, Tdsp tdsp, String tdspMeterId,
                    String addressLine1, String addressLine2, String city,
                    State state, String zipCode) {
}
