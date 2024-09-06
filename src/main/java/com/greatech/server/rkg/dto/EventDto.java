package com.greatech.server.rkg.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "Event")
public class EventDto {

    @JsonSerialize(using= ToStringSerializer.class)
    @Schema(name = "id", type = "Long")
    private Long id;

    @Schema(name = "determine", type = "String")
    private String determine;
}
