package com.ossrep.service.iso;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class IsoRepository implements PanacheRepositoryBase<IsoEntity, Short> {
}