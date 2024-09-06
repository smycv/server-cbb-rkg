package com.greatech.server.rkg.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonRawValue;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "Edge")
public class RkgedgeDto {

    @JsonIgnore
    @Schema(name = "id", type = "Long")
    private Long id;

    @Schema(name = "source", type = "String")
    private String source;

    @Schema(name = "target", type = "String")
    private String target;

    @JsonRawValue
    @Schema(name = "style", type = "String")
    private String style;
}
