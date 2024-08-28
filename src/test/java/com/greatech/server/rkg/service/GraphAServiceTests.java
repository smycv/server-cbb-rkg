package com.greatech.server.rkg.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.greatech.server.rkg.RKGApplication;
import com.greatech.server.rkg.dao.*;
import com.greatech.server.rkg.pojo.*;
import org.apache.commons.text.StringEscapeUtils;
import org.junit.jupiter.api.Test;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualToWhenPresent;
import static org.mybatis.dynamic.sql.SqlBuilder.select;

@SpringBootTest(classes = RKGApplication.class)
public class GraphAServiceTests {

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
            ETRkgedgeA edge = new ETRkgedgeA();
            edge.setSource(risk.getId() + "");
            edge.setTarget(r.getEventId() + "");
            edge.setStyle("{\"endArrow\":true," +
                    "\"lineWidth\":2," +
                    "\"stroke\":\"#AF42EB\"," +
                    "\"labelText\":\"风险的事件\"}");

            System.out.println("已增边：" + edge);
            graphService.addEdgeA(edge);
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
                    ETRkgedgeA edge = new ETRkgedgeA();
                    edge.setSource(other_risk_id + "");
                    edge.setTarget(r.getRiskId() + "");
                    edge.setStyle("{\"endArrow\":true," +
                            "\"lineWidth\":2," +
                            "\"stroke\":\"#AF42EB\"," +
                            "\"labelText\":\"风险（原因）导致风险\"}");
                    System.out.println("已增边：" + edge);
                    graphService.addEdgeA(edge);
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
                    ETRkgedgeA edge = new ETRkgedgeA();
                    edge.setSource(r.getRiskId() + "");
                    edge.setTarget(other_risk_id + "");
                    edge.setStyle("{\"endArrow\":true," +
                            "\"lineWidth\":2," +
                            "\"stroke\":\"#AF42EB\"," +
                            "\"labelText\":\"风险导致风险(后果)\"}");
                    System.out.println("已增边：" + edge);
                    graphService.addEdgeA(edge);
                }
            }
        }

    }

    @Autowired
    ETRkgnodeAMapper eTRkgnodeAMapper;

    @Autowired
    ETRkgedgeAMapper eTRkgedgeAMapper;




    @Test
    void getGraph() throws Exception {


        SelectStatementProvider sqlDsl = select(ETRkgnodeADynamicSqlSupport.ETRkgnodeA.allColumns())
                .from(ETRkgnodeADynamicSqlSupport.ETRkgnodeA)
                .where(ETRkgnodeADynamicSqlSupport.ETRkgnodeA.nodeClass, isEqualToWhenPresent("risk"))
//                .or(ETRkgnodeADynamicSqlSupport.ETRkgnodeA.nodeClass, isEqualToWhenPresent("facility"))
                .build()
                .render(RenderingStrategies.MYBATIS3);

        List<ETRkgnodeA> nodeList = eTRkgnodeAMapper.selectMany(sqlDsl);

        SelectStatementProvider sqlDsl_ = select(ETRkgedgeADynamicSqlSupport.ETRkgedgeA.allColumns())
                .from(ETRkgedgeADynamicSqlSupport.ETRkgedgeA)
                .where(SqlColumn.of("style -> '$.labelText'", SqlTable.of("e_t_rkgedge_a")), isEqualToWhenPresent("风险导致风险(后果)"))
//                .or(SqlColumn.of("style -> '$.labelText'", SqlTable.of("e_t_rkgedge_a")), isEqualToWhenPresent("风险的主体"))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        System.out.println(sqlDsl_.getSelectStatement());
        List<ETRkgedgeA> edgeList = eTRkgedgeAMapper.selectMany(sqlDsl_);


//        for (ETRkgnodeA etRkgnodeA : nodeList) {
//            etRkgnodeA.setData(StringEscapeUtils.unescapeJava(etRkgnodeA.getData()));
//            etRkgnodeA.setStyle(StringEscapeUtils.unescapeJava(etRkgnodeA.getStyle()));
//        }
//        for (ETRkgedgeA l : edgeList) {
//            l.setStyle(StringEscapeUtils.unescapeJava(l.getStyle()));
//        }

        SimpleModule simpleModule = new SimpleModule().addSerializer(Long.class, ToStringSerializer.instance);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(simpleModule);
        String jsonNodeList = objectMapper.writeValueAsString(nodeList);
        String jsonEdgeList = objectMapper.writeValueAsString(edgeList);
        System.out.println(jsonNodeList.replace("\"{","{").replace("}\"","}").replace("\\",""));
        System.out.println("----------------------------------------");
        System.out.println("----------------------------------------");
        System.out.println("----------------------------------------");
        System.out.println(jsonEdgeList.replace("\"{","{").replace("}\"","}").replace("\\",""));
    }


    @Test
    void test(){
        String s1="{\\\"risk\\\": \\\"粗裂解汽油/6''-P-70001流量下降(FIC70005)\\\"}";
        System.out.println(s1);
        System.out.println(StringEscapeUtils.unescapeJava(s1));
    }
}
