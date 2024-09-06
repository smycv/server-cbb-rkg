package com.greatech.server.rkg.converter;

import com.greatech.server.rkg.dto.EventDto;
import com.greatech.server.rkg.pojo.ETEvent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EventDtoMapper {

    @Mappings({
            @Mapping(source = "record.id", target = "id"),
            @Mapping(source = "record.determine", target = "determine")
    })
    EventDto convert(ETEvent record);

    List<EventDto> convert(List<ETEvent> list);

    @Mappings({
            @Mapping(source = "record.id", target = "id"),
            @Mapping(source = "record.determine", target = "determine")
    })
    ETEvent reconvert(EventDto record);

    List<ETEvent> reconvert(List<EventDto> list);
}
