package com.ossrep.service.meter;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.validation.constraints.NotEmpty;

import java.util.Optional;

@ApplicationScoped
public class MeterRepository implements PanacheRepositoryBase<MeterEntity, Long> {

    Optional<MeterEntity> findByTdspMeterId(@NotEmpty String tdspMeterId) {
        return find("tdspMeterId", tdspMeterId).firstResultOptional();
    }

}