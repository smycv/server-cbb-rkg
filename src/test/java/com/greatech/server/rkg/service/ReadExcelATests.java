package com.greatech.server.rkg.service;

import com.greatech.server.rkg.RKGApplication;
import com.greatech.server.rkg.pojo.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.util.Optional;

@SpringBootTest(classes = RKGApplication.class)
public class ReadExcelATests {

    //    @Transactional
    @Test
    void read() throws Exception {
        //1.还是一样得到一个excel文件对象，但是我们这里是读 ， 所以要指定文件路径
        FileInputStream fileInputStream = new FileInputStream(new File("D:\\rkg-demo\\test2.xlsx"));
        XSSFWorkbook excel = new XSSFWorkbook(fileInputStream);
        //2.读取excel文件中的sheet1页（因为这个文件就只创建了一个sheet页）
        //XSSFSheet sheet = excel.getSheetAt(0);//这是直接拿第一个sheet页
        XSSFSheet sheet = excel.getSheet("工作表1");//这是根据sheet页的名字来拿sheet页
        //3.遍历所有行，但是我不知道有多少行，所以我可以直接获取最后有文字的那一行，这样就知道一个有多少行了
        int lastRowNum = sheet.getLastRowNum();//获取有文字的最后一行行号
        System.out.println("最后行号：" + lastRowNum);
        for (int i = 2; i <= lastRowNum; ++i) {
            //获得某一行
            XSSFRow row = sheet.getRow(i);
            //4.遍历该行得所有单元格对象,并且获取该单元格对象中得数据
            if (Optional.ofNullable(row).isPresent()) {
                System.out.println("当前处理 第" + row.getRowNum() + "行:");

//                for (Cell cell : row) {
//                    String stringCellValue = cell.getStringCellValue();
//                    int column = cell.getColumnIndex();
//                    System.out.print("test：："+cell.equals(row.getCell(column)));
//                    System.out.print("第" + column + "列:" + stringCellValue + "\t");
//                }
                importEvent4Row(row);
            }
            //读完一行的数据后换行
            System.out.println("第" + row.getRowNum() + "行 已导入");
        }
        //5.关闭资源
        excel.close();
        fileInputStream.close();
    }

    @Autowired
    ImportService importService;

    @Autowired
    GraphService graphService;

    void importEvent4Row(XSSFRow row) {


        //风险
        var risk_content = row.getCell(4).getStringCellValue();

        //风险node
//        ETRkgnode node_risk = new ETRkgnode();
//        node_risk.setName(risk_content);
//        node_risk.setObj("risk");
//        node_risk.setColor("yellow");
//        node_risk.setType("circle");
//        node_risk = graphService.addNode(node_risk);

        ETRkgnodeA node_risk_a = new ETRkgnodeA();
        node_risk_a.setData("{\"risk\":\"" + risk_content + "\"}");
        node_risk_a.setNodeClass("risk");
        node_risk_a.setStyle("{\"fill\":\"#00C691\"}");
        node_risk_a.setType("circle");
        node_risk_a = graphService.addNodeA(node_risk_a);


        ETRisk risk = new ETRisk();
        risk.setId(node_risk_a.getId());
        risk.setContent(risk_content);
        importService.selectOrAddETRisk(risk);


        //风险主体事件
        var facility_tn = row.getCell(1).getStringCellValue();
        var facility_name = row.getCell(2).getStringCellValue();
        var event_condition = row.getCell(3).getStringCellValue();

        //主体node
//        ETRkgnode node_facility = new ETRkgnode();
//        node_facility.setName(facility_tn);
//        node_facility.setObj("facility");
//        node_facility.setColor("#4F85F6");
//        node_facility.setType("rect");
//        node_facility = graphService.addNode(node_facility);

        ETRkgnodeA node_facility_a = new ETRkgnodeA();
        node_facility_a.setData("{\"facility\":\"" + facility_tn + "\"}");
        node_facility_a.setNodeClass("facility");
        node_facility_a.setStyle("{\"fill\":\"#4F85F6\"}");
        node_facility_a.setType("rect");
        node_facility_a = graphService.addNodeA(node_facility_a);

        ETFacility facility = new ETFacility();
        facility.setId(node_facility_a.getId());
        facility.setTn(facility_tn);
        facility.setName(facility_name);
        facility = importService.selectOrAddETFacility(facility);


        //edge 风险到主体
//        ETRkgedge edge_facility = new ETRkgedge();
//        edge_facility.setSource(risk.getId());
//        edge_facility.setTarget(facility.getId());
//        edge_facility.setTag("风险的主体");
//        graphService.addEdge(edge_facility);

        ETRkgedgeA edge_facility_a = new ETRkgedgeA();
        edge_facility_a.setSource(risk.getId() + "");
        edge_facility_a.setTarget(facility.getId() + "");
        edge_facility_a.setStyle("{\"endArrow\":true," +
                "\"lineWidth\":2," +
                "\"stroke\":\"#4F85F6\"," +
                "\"labelText\":\"风险的主体\"}");
        graphService.addEdgeA(edge_facility_a);

        //事件node
//        ETRkgnode node_event = new ETRkgnode();
//        node_event.setName(event_condition);
//        node_event.setObj("event");
//        node_event.setColor("#F3AE3D");
//        node_event.setType("circle");
//        node_event = graphService.addNode(node_event);

        ETRkgnodeA node_event_a = new ETRkgnodeA();
        node_event_a.setData("{\"event\":\"" + event_condition + "\"}");
        node_event_a.setNodeClass("event");
        node_event_a.setStyle("{\"fill\":\"#DE789D\"}");
        node_event_a.setType("circle");
        node_event_a = graphService.addNodeA(node_event_a);

        ETEvent event = new ETEvent();
        event.setId(node_event_a.getId());
        event.setDetermine(event_condition);
        event = importService.selectOrAddETEvent(event);

        importService.selectOrAddRTFacilityEvent(facility, event);

        importService.selectOrAddRTRiskEvent(risk, event);


        if (Optional.ofNullable(row.getCell(8)).isPresent()) {
            //原因
            var reason_content = row.getCell(8).getStringCellValue();
            if (StringUtils.isNotBlank(reason_content)) {
                //原因node
//                ETRkgnode node_reason = new ETRkgnode();
//                node_reason.setName(reason_content);
//                node_reason.setObj("reason");
//                node_reason.setColor("#00C691");
//                node_reason.setType("circle");
//                node_reason = graphService.addNode(node_reason);

                ETRkgnodeA node_reason_a = new ETRkgnodeA();
                node_reason_a.setData("{\"reason\":\"" + reason_content + "\"}");
                node_reason_a.setNodeClass("reason");
                node_reason_a.setStyle("{\"fill\":\"#00C691\"}");
                node_reason_a.setType("circle");
                node_reason_a = graphService.addNodeA(node_reason_a);

                ETReason reason = new ETReason();
                reason.setId(node_reason_a.getId());
                reason.setContent(reason_content);
                importService.selectOrAddETReason(reason);

                //风险的原因
                importService.selectOrAddRTRiskReason(risk, reason);

                //edge 原因到风险
//                ETRkgedge edge_reason = new ETRkgedge();
//                edge_reason.setSource(reason.getId());
//                edge_reason.setTarget(risk.getId());
//                edge_reason.setTag("原因导致风险发生");
//                graphService.addEdge(edge_reason);

                ETRkgedgeA edge_reason_a = new ETRkgedgeA();
                edge_reason_a.setSource(reason.getId()+"");
                edge_reason_a.setTarget(risk.getId()+"");
                edge_reason_a.setStyle("{\"endArrow\":true," +
                        "\"lineWidth\":2," +
                        "\"stroke\":\"#F3AE3D\"," +
                        "\"labelText\":\"原因导致风险发生\"\"}");
                graphService.addEdgeA(edge_reason_a);

                //原因中主体事件
                if (Optional.ofNullable(row.getCell(5)).isPresent()) {
                    facility_tn = row.getCell(5).getStringCellValue();
                    if (StringUtils.isNotBlank(facility_tn)) {
                        //主体node
                        node_facility_a = new ETRkgnodeA();
                        node_facility_a.setData("{\"facility\":\"" + facility_tn + "\"}");
                        node_facility_a.setNodeClass("facility");
                        node_facility_a.setStyle("{\"fill\":\"#4F85F6\"}");
                        node_facility_a.setType("rect");
                        node_facility_a = graphService.addNodeA(node_facility_a);

                        facility_name = row.getCell(6).getStringCellValue();
                        facility.setId(node_facility_a.getId());
                        facility.setTn(facility_tn);
                        facility.setName(facility_name);
                        facility = importService.selectOrAddETFacility(facility);
                        if (Optional.ofNullable(row.getCell(7)).isPresent()) {
                            event_condition = row.getCell(7).getStringCellValue();
                            if (StringUtils.isNotBlank(event_condition)) {

                                //事件node
                                node_event_a = new ETRkgnodeA();
                                node_event_a.setData("{\"event\":\"" + event_condition + "\"}");
                                node_event_a.setNodeClass("event");
                                node_event_a.setStyle("{\"fill\":\"#DE789D\"}");
                                node_event_a.setType("circle");
                                node_event_a = graphService.addNodeA(node_event_a);

                                event.setId(node_event_a.getId());
                                event.setDetermine(event_condition);
                                event = importService.selectOrAddETEvent(event);

                                importService.selectOrAddRTFacilityEvent(facility, event);

                                //原因的事件
                                importService.selectOrAddRTReasonEvent(reason, event);
                            }
                        }
                    }
                }
            }
        }


        if (Optional.ofNullable(row.getCell(12)).isPresent()) {

            //后果
            var result_content = row.getCell(12).getStringCellValue();

            if (StringUtils.isNotBlank(result_content)) {

                //后果node
//                ETRkgnode node_result = new ETRkgnode();
//                node_result.setName(result_content);
//                node_result.setObj("result");
//                node_result.setColor("#AF42EB");
//                node_result.setType("circle");
//                node_result = graphService.addNode(node_result);

                ETRkgnodeA node_result_a = new ETRkgnodeA();
                node_result_a.setData("{\"result\":\"" + result_content + "\"}");
                node_result_a.setNodeClass("result");
                node_result_a.setStyle("{\"fill\":\"#F3AE3D\"}");
                node_result_a.setType("circle");
                node_result_a = graphService.addNodeA(node_result_a);


                ETResult result = new ETResult();
                result.setId(node_result_a.getId());
                result.setContent(result_content);
                importService.selectOrAddETResult(result);

                //风险的后果
                importService.selectOrAddRTRiskResult(risk, result);

                //edge 风险到后果
//                ETRkgedge edge_result = new ETRkgedge();
//                edge_result.setSource(risk.getId());
//                edge_result.setTarget(result.getId());
//                edge_result.setTag("风险发生导致后果");
//                graphService.addEdge(edge_result);

                ETRkgedgeA edge_result_a = new ETRkgedgeA();
                edge_result_a.setSource(risk.getId()+"");
                edge_result_a.setTarget(result.getId()+"");
                edge_result_a.setStyle("{\"endArrow\":true," +
                        "\"lineWidth\":2," +
                        "\"stroke\":\"#AF42EB\"," +
                        "\"labelText\":\"风险发生导致后果\"}");
                graphService.addEdgeA(edge_result_a);

                //后果中主体事件
                facility_tn = row.getCell(9).getStringCellValue();
                if (StringUtils.isNotBlank(facility_tn)) {
                    //主体node
                    node_facility_a = new ETRkgnodeA();
                    node_facility_a.setData("{\"facility\":\"" + facility_tn + "\"}");
                    node_facility_a.setNodeClass("facility");
                    node_facility_a.setStyle("{\"fill\":\"#4F85F6\"}");
                    node_facility_a.setType("rect");
                    node_facility_a = graphService.addNodeA(node_facility_a);

                    facility_name = row.getCell(10).getStringCellValue();
                    facility.setId(node_facility_a.getId());
                    facility.setTn(facility_tn);
                    facility.setName(facility_name);
                    facility = importService.selectOrAddETFacility(facility);
                    if (Optional.ofNullable(row.getCell(11)).isPresent()) {
                        event_condition = row.getCell(11).getStringCellValue();
                        if (StringUtils.isNotBlank(event_condition)) {

                            //事件node
                            node_event_a = new ETRkgnodeA();
                            node_event_a.setData("{\"event\":\"" + event_condition + "\"}");
                            node_event_a.setNodeClass("event");
                            node_event_a.setStyle("{\"fill\":\"#DE789D\"}");
                            node_event_a.setType("circle");
                            node_event_a = graphService.addNodeA(node_event_a);

                            event.setId(node_event_a.getId());
                            event.setDetermine(event_condition);
                            event = importService.selectOrAddETEvent(event);
                            importService.selectOrAddRTFacilityEvent(facility, event);
                            //后果的事件
                            importService.selectOrAddRTResultEvent(result, event);
                        }
                    }
                }
            }
        }


        if (Optional.ofNullable(row.getCell(16)).isPresent()) {
            //措施
            var measure_content = row.getCell(16).getStringCellValue();

            if (StringUtils.isNotBlank(measure_content)) {
                //措施node
//                ETRkgnode node_measure = new ETRkgnode();
//                node_measure.setName(measure_content);
//                node_measure.setObj("measure");
//                node_measure.setColor("#DE789D");
//                node_measure.setType("circle");
//                node_measure = graphService.addNode(node_measure);

                ETRkgnodeA node_measure_a = new ETRkgnodeA();
                node_measure_a.setData("{\"measure\":\"" + measure_content + "\"}");
                node_measure_a.setNodeClass("measure");
                node_measure_a.setStyle("{\"fill\":\"#59C4F7\"}");
                node_measure_a.setType("circle");
                node_measure_a = graphService.addNodeA(node_measure_a);

                ETMeasure measure = new ETMeasure();
                measure.setId(node_measure_a.getId());
                measure.setContent(measure_content);
                importService.selectOrAddETMeasure(measure);
                //风险的措施
                importService.selectOrAddRTRiskMeasure(risk, measure);

                //edge 风险到措施
//                ETRkgedge edge_measure = new ETRkgedge();
//                edge_measure.setSource(risk.getId());
//                edge_measure.setTarget(measure.getId());
//                edge_measure.setTag("风险的措施");
//                graphService.addEdge(edge_measure);

                ETRkgedgeA edge_measure_a = new ETRkgedgeA();
                edge_measure_a.setSource(risk.getId()+"");
                edge_measure_a.setTarget(measure.getId()+"");
                edge_measure_a.setStyle("{\"endArrow\":true," +
                        "\"lineWidth\":2," +
                        "\"stroke\":\"#59C4F7\"," +
                        "\"labelText\":\"风险的措施\"}");
                graphService.addEdgeA(edge_measure_a);
            }
        }
    }

}
