package com.greatech.server.rkg.converter;

import com.greatech.server.rkg.dto.RkgedgeDto;
import com.greatech.server.rkg.pojo.ETRkgedgeA;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RkgedgeDtoMapper {

    @Mappings({
            @Mapping(source = "record.id", target = "id"),
            @Mapping(source = "record.source", target = "source"),
            @Mapping(source = "record.target", target = "target"),
            @Mapping(source = "record.style", target = "style")
    })
    RkgedgeDto convert(ETRkgedgeA record);

    List<RkgedgeDto> convert(List<ETRkgedgeA> record);
}
