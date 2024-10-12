package com.ossrep.meter.tdsp;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TdspRepository implements PanacheRepositoryBase<TdspEntity, Short> {
}
