package com.ossrep.meter.tdsp;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class TdspService {

    private final TdspRepository tdspRepository;
    private final TdspMapper tdspMapper;

    public TdspService(TdspRepository tdspRepository, TdspMapper tdspMapper) {
        this.tdspRepository = tdspRepository;
        this.tdspMapper = tdspMapper;
    }

    public List<Tdsp> findAll() {
        return tdspRepository.findAll().stream().map(tdspMapper::toDomain).toList();
    }

}
