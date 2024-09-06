package com.greatech.server.rkg.converter;

import com.greatech.server.rkg.dto.RkgnodeDto;
import com.greatech.server.rkg.pojo.ETRkgnodeA;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RkgnodeDtoMapper {


    @Mappings({
            @Mapping(source = "record.id", target = "id"),
            @Mapping(source = "record.nodeClass", target = "nodeClass"),
            @Mapping(source = "record.data", target = "data"),
            @Mapping(source = "record.style", target = "style"),
            @Mapping(source = "record.type", target = "type")
    })
    RkgnodeDto convert(ETRkgnodeA record);

    List<RkgnodeDto> convert(List<ETRkgnodeA> record);


}
