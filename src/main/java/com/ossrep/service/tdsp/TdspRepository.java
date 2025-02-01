package com.ossrep.service.tdsp;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;

@ApplicationScoped
public class TdspRepository implements PanacheRepositoryBase<TdspEntity, Short> {

    public Optional<TdspEntity> findByCode(String code) {
        return find("code", code).firstResultOptional();
    }

}