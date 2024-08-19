package com.greatech.server.rkg.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.greatech.server.rkg.RKGApplication;
import com.greatech.server.rkg.dao.*;
import com.greatech.server.rkg.pojo.*;
import org.junit.jupiter.api.Test;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@SpringBootTest(classes = RKGApplication.class)
public class GraphServiceTests {

    @Autowired
    ETReasonMapper eTReasonMapper;

    @Autowired
    ETResultMapper eTResultMapper;

    @Autowired
    RiskService riskService;

    @Autowired
    GraphService graphService;

    @Autowired
    ETRiskMapper eTRiskMapper;


    @Test
    void edgeEventToRisk() {

        List<ETRisk> risk_list = eTRiskMapper.select(SelectDSLCompleter.allRows());
        for (ETRisk risk : risk_list) {
            RTRiskEvent r = riskService.findRTRiskEvent(risk);
            ETRkgedge edge = new ETRkgedge();
            edge.setSource(risk.getId());
            edge.setTarget(r.getEventId());
            edge.setTag("风险的事件");
            System.out.println("已增边：" + edge);
            graphService.addEdge(edge);
        }

    }

    //    @Transactional
    @Test
    void edgeRiskToRisk() {

        List<ETReason> reason_list = eTReasonMapper.select(SelectDSLCompleter.allRows());

        for (ETReason reason : reason_list) {
            Long other_risk_id = riskService.findOtherRiskByReason(reason);
//            System.out.println("other_risk_id：" + other_risk_id);
            if (Optional.ofNullable(other_risk_id).isPresent()) {
                List<RTRiskReason> list = riskService.findCurrentRiskByReason(reason);
                for (RTRiskReason r : list) {
                    ETRkgedge edge = new ETRkgedge();
                    edge.setSource(other_risk_id);
                    edge.setTarget(r.getRiskId());
                    edge.setTag("风险（原因）导致风险");
                    System.out.println("已增边：" + edge);
                    graphService.addEdge(edge);
                }
            }
        }

        List<ETResult> result_list = eTResultMapper.select(SelectDSLCompleter.allRows());

        for (ETResult result : result_list) {
            Long other_risk_id = riskService.findOtherRiskByResult(result);
//            System.out.println("other_risk_id：" + other_risk_id);
            if (Optional.ofNullable(other_risk_id).isPresent()) {
                List<RTRiskResult> list = riskService.findCurrentRiskByResult(result);
                for (RTRiskResult r : list) {
                    ETRkgedge edge = new ETRkgedge();
                    edge.setSource(r.getRiskId());
                    edge.setTarget(other_risk_id);
                    edge.setTag("风险导致风险(后果)");
                    System.out.println("已增边：" + edge);
                    graphService.addEdge(edge);
                }
            }
        }

    }

    @Autowired
    ETRkgnodeMapper eTRkgnodeMapper;

    @Autowired
    ETRkgedgeMapper eTRkgedgeMapper;

    @Test
    void getGraph() throws Exception {
        List<ETRkgnode> nodeList = eTRkgnodeMapper.select(SelectDSLCompleter.allRows());
        List<ETRkgedge> edgeList = eTRkgedgeMapper.select(SelectDSLCompleter.allRows());
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonNodeList = objectMapper.writeValueAsString(nodeList);
        String jsonEdgeList = objectMapper.writeValueAsString(edgeList);
        System.out.println(jsonNodeList);
        System.out.println(jsonEdgeList);
    }

}
