package com.ossrep.service.iso;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

import java.util.Objects;

@Entity(name = "Iso")
@Table(name = "iso")
public class IsoEntity {

    @Id
    @Column(name = "iso_id")
    public Short isoId;

    @Column(name = "code")
    @NotEmpty(message = "{Iso.code.required}")
    public String code;

    @Column(name = "name")
    @NotEmpty(message = "{Iso.name.required}")
    public String name;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        IsoEntity isoEntity = (IsoEntity) o;
        return Objects.equals(isoId, isoEntity.isoId) && Objects.equals(code, isoEntity.code) && Objects.equals(name, isoEntity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isoId, code, name);
    }

    @Override
    public String toString() {
        return "IsoEntity{" +
                "isoId=" + isoId +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

}
