package com.ossrep.meter.meter;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.JAKARTA_CDI)
public interface MeterMapper {

    Meter toDomain(MeterEntity entity);

    MeterEntity toEntity(Meter domain);

}
