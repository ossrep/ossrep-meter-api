package com.ossrep.service.meter;

import com.ossrep.service.tdsp.TdspEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Entity(name = "Meter")
@Table(name = "meter")
public class MeterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meter_id")
    public Long meterId;

    @ManyToOne
    @JoinColumn(name = "tdsp_id")
    @NotNull(message = "{Meter.tdsp.required}")
    public TdspEntity tdsp;

    @Column(name = "tdsp_meter_id")
    @NotEmpty(message = "{Meter.tdspMeterId.required}")
    public String tdspMeterId;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MeterEntity that = (MeterEntity) o;
        return Objects.equals(meterId, that.meterId) && Objects.equals(tdsp, that.tdsp) && Objects.equals(tdspMeterId, that.tdspMeterId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(meterId, tdsp, tdspMeterId);
    }

    @Override
    public String toString() {
        return "MeterEntity{" +
                "meterId=" + meterId +
                ", tdsp=" + tdsp +
                ", code='" + tdspMeterId + '\'' +
                '}';
    }

}