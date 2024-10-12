package com.ossrep.meter.meter;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MeterRepository implements PanacheRepositoryBase<MeterEntity, Long> {
}
