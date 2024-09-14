package com.greatech.server.rkg.controller;

import com.greatech.server.common.global.BaseResponse;
import com.greatech.server.common.global.SuccessResponse;
import com.greatech.server.rkg.converter.EventDtoMapper;
import com.greatech.server.rkg.converter.RiskDtoMapper;
import com.greatech.server.rkg.converter.RkgedgeDtoMapper;
import com.greatech.server.rkg.converter.RkgnodeDtoMapper;
import com.greatech.server.rkg.dto.DateDto;
import com.greatech.server.rkg.dto.EventDto;
import com.greatech.server.rkg.dto.RiskDto;
import com.greatech.server.rkg.pojo.ETRkgedgeA;
import com.greatech.server.rkg.pojo.ETRkgnodeA;
import com.greatech.server.rkg.service.GraphService;
import com.greatech.server.rkg.service.RiskService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "0.0.1")
public class RiskController {

    @Resource
    GraphService graphService;

    @Resource
    RkgnodeDtoMapper rkgnodeDtoMapper;

    @Resource
    RkgedgeDtoMapper rkgedgeDtoMapper;

    @CrossOrigin
    @Operation(summary = "查询G6的data", description = "需要authenticationToken验证", method = "GET")
    @GetMapping("/data")
    BaseResponse<DateDto> data() {
        DateDto record = new DateDto();
        List<ETRkgnodeA> listETRkgnodeA = graphService.findNodeB();
//        for (ETRkgnodeA r : listETRkgnodeA) {
//            r.setData(r.getData().replace("\"{", "{").replace("}\"", "}").replace("\\", ""));
//            r.setStyle(r.getStyle().replace("\"{", "{").replace("}\"", "}").replace("\\", ""));
//        }
        record.setNodes(rkgnodeDtoMapper.convert(listETRkgnodeA));
        List<ETRkgedgeA> listETRkgedgeA = graphService.findEdgeB();

//        listETRkgedgeA.forEach(r -> r.setStyle(r.getStyle().replace("\"{", "{").replace("}\"", "}").replace("\\", "")));
        record.setEdges(rkgedgeDtoMapper.convert(listETRkgedgeA));
        log.info(record.toString());
        return SuccessResponse.success(record);
    }

    @Resource
    RiskDtoMapper riskDtoMapper;

    @Resource
    EventDtoMapper eventDtoMapper;
    @Resource
    RiskService riskService;
    @CrossOrigin
    @Operation(summary = "查询风险的事件", description = "需要authenticationToken验证", method = "POST")
    @PostMapping("/event")
    BaseResponse<EventDto> event(@RequestBody @Validated RiskDto riskDto){
        return SuccessResponse.success(eventDtoMapper.convert(riskService.findEvent(riskDtoMapper.reconvert(riskDto))));
    }

}
