package com.ossrep.meter.api.v1;

import com.ossrep.meter.meter.Meter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.JAKARTA_CDI)
public interface ApiMapper {

    @Mapping(source = "tdsp.iso", target = "iso")
    @Mapping(source = "tdsp.code", target = "tdsp")
    MeterV1 toApi(Meter meter);

}
