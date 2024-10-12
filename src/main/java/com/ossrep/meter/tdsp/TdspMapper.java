package com.ossrep.meter.tdsp;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.JAKARTA_CDI)
public interface TdspMapper {

    Tdsp toDomain(TdspEntity entity);

    TdspEntity toEntity(Tdsp domain);

}
