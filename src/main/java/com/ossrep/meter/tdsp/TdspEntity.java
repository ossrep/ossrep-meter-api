package com.ossrep.meter.tdsp;

import com.ossrep.meter.Iso;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Entity(name = "Tdsp")
@Table(name = "tdsp")
public class TdspEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tdsp_id")
    public Short tdspId;

    @Enumerated(EnumType.STRING)
    @Column(name = "iso", columnDefinition = "iso_us")
    @NotNull(message = "{Tdsp.code.required}")
    public Iso iso;

    @Column(name = "code")
    @NotEmpty(message = "{Tdsp.code.required}")
    public String code;

    @Column(name = "name")
    @NotEmpty(message = "{Tdsp.name.required}")
    public String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TdspEntity that = (TdspEntity) o;
        return Objects.equals(tdspId, that.tdspId) && iso == that.iso && Objects.equals(code, that.code) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tdspId, iso, code, name);
    }

    @Override
    public String toString() {
        return "TdspEntity{" +
                "tdspId=" + tdspId +
                ", iso=" + iso +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

}
