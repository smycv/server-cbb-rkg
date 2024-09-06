package com.greatech.server.rkg.dto;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "Node")
public class RkgnodeDto {

    @JsonSerialize(using= ToStringSerializer.class)
    @Schema(name = "id", type = "Long")
    private Long id;

    @Schema(name = "nodeClass", type = "String")
    private String nodeClass;

    @Schema(name = "type", type = "String")
    private String type;

    @JsonRawValue
    @Schema(name = "data", type = "String")
    private String data;

    @JsonRawValue
    @Schema(name = "style", type = "String")
    private String style;
}
