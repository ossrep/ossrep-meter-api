package com.ossrep.service.tdsp;

import com.ossrep.service.iso.IsoEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.Objects;

@Entity(name = "Tdsp")
@Table(name = "tdsp")
public class TdspEntity {

    @Id
    @Column(name = "tdsp_id")
    public Short tdspId;

    @ManyToOne
    @JoinColumn(name = "iso_id")
    public IsoEntity iso;

    @Column(name = "code")
    @NotEmpty(message = "{Tdsp.code.required}")
    public String code;

    @Column(name = "name")
    @NotEmpty(message = "{Tdsp.name.required}")
    public String name;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TdspEntity that = (TdspEntity) o;
        return Objects.equals(tdspId, that.tdspId) && Objects.equals(iso, that.iso) && Objects.equals(code, that.code) && Objects.equals(name, that.name);
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