package com.ossrep.meter.meter;

import com.ossrep.meter.State;
import com.ossrep.meter.tdsp.TdspEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity(name = "Meter")
@Table(name = "meter")
public class MeterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meter_id")
    public Long meterId;

    @ManyToOne
    @JoinColumn(name = "tdsp_id")
    public TdspEntity tdsp;

    @Column(name = "tdsp_meter_id")
    @NotEmpty(message = "{Meter.tdspMeterId.required}")
    public String tdspMeterId;

    @Column(name = "address_line_1")
    @NotEmpty(message = "{Meter.addressLine1.required}")
    public String addressLine1;

    @Column(name = "address_line_2")
    public String addressLine2;

    @Column(name = "city")
    @NotEmpty(message = "{Meter.city.required}")
    public String city;

    @Enumerated(EnumType.STRING)
    @Column(name = "state", columnDefinition = "state")
    @NotNull(message = "{Meter.state.required}")
    public State state;

    @Column(name = "zip_code")
    @NotEmpty(message = "{Meter.zipCode.required}")
    public String zipCode;

}
