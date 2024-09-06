package com.greatech.server.rkg.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "Edge")
public class DateDto {

    @Schema(name = "nodes", type = "RkgnodeDto")
    List<RkgnodeDto> nodes;

    @Schema(name = "edges", type = "RkgedgeDto")
    List<RkgedgeDto> edges;

}
