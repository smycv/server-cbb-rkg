package com.greatech.server.rkg.converter;

import com.greatech.server.rkg.dto.RiskDto;
import com.greatech.server.rkg.pojo.ETRisk;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RiskDtoMapper {

    @Mappings({@Mapping(source = "record.id", target = "id")})
    RiskDto convert(ETRisk record);

    @Mappings({@Mapping(source = "record.id", target = "id")})
    ETRisk reconvert(RiskDto record);
}
