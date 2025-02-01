package com.ossrep.service.iso;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;

@ApplicationScoped
public class IsoService {

    private final IsoRepository isoRepository;

    public IsoService(IsoRepository isoRepository) {
        this.isoRepository = isoRepository;
    }

    public Optional<Iso> findByIsoCode(String isoCode) {
        return isoRepository.find("code", isoCode).firstResultOptional()
                .map(isoEntity -> new Iso(isoEntity.code, isoEntity.name));
    }

}
