package com.ossrep.service.meter;

import com.ossrep.service.exception.ServiceException;
import com.ossrep.service.tdsp.TdspRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotEmpty;

import java.util.Optional;

@ApplicationScoped
public class MeterService {

    private MeterRepository meterRepository;
    private TdspRepository tdspRepository;

    public MeterService(MeterRepository meterRepository, TdspRepository tdspRepository) {
        this.meterRepository = meterRepository;
        this.tdspRepository = tdspRepository;
    }

    public Optional<Meter> findByTdspMeterId(@NotEmpty String tdspMeterId) {
        return meterRepository.findByTdspMeterId(tdspMeterId).map(this::from);
    }

    @Transactional
    public void save(Meter meter) {
        MeterEntity meterEntity = from(meter);
        meterRepository.persist(meterEntity);
    }

    private Meter from(MeterEntity meterEntity) {
        return new Meter(meterEntity.tdsp.code, meterEntity.tdspMeterId);
    }

    private MeterEntity from(Meter meter) {
        MeterEntity meterEntity = meterRepository.findByTdspMeterId(meter.tdspMeterId()).orElseGet(MeterEntity::new);
        meterEntity.tdsp = tdspRepository.findByCode(meter.tdspCode()).orElseThrow(() -> new ServiceException("%s not found", meter.tdspCode()));
        meterEntity.tdspMeterId = meter.tdspMeterId();
        return meterEntity;
    }

}
