package com.ossrep.meter.meter;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class MeterService {

    private final MeterRepository meterRepository;
    private final MeterMapper meterMapper;

    public MeterService(MeterRepository meterRepository, MeterMapper meterMapper) {
        this.meterRepository = meterRepository;
        this.meterMapper = meterMapper;
    }

    public List<Meter> findAll() {
        return meterRepository.findAll().stream().map(meterMapper::toDomain).toList();
    }

    public Optional<Meter> findByTdspMeterId(String tdspMeterId) {
        return meterRepository.find("tdspMeterId", tdspMeterId).firstResultOptional().map(meterMapper::toDomain);
    }

}
