package com.greatech.server.rkg.service;

import com.greatech.server.rkg.RKGApplication;
import com.greatech.server.rkg.pojo.ETRkgedgeA;
import com.greatech.server.rkg.pojo.ETRkgnodeA;
import com.greatech.server.rkg.repository.RKGRepository;
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
public class ReadExcelBTests {


    @Autowired
    GraphService graphService;


    @Autowired
    RKGRepository rKGRepository;

    // @Transactional
    @Test
    void read() throws Exception {
        //1.还是一样得到一个excel文件对象，但是我们这里是读 ， 所以要指定文件路径
        FileInputStream fileInputStream = new FileInputStream(new File("D:\\rkg-demo\\模板v0.0.2.20240911.xlsx"));
        XSSFWorkbook excel = new XSSFWorkbook(fileInputStream);

        XSSFSheet sheet = null;

        int lastRowNum = 0;

        sheet = excel.getSheet("01实体");
        lastRowNum = sheet.getLastRowNum();//获取有文字的最后一行行号
        System.out.println("最后行号：" + lastRowNum);
        for (int i = 1; i <= lastRowNum; ++i) {
            XSSFRow row = sheet.getRow(i);
            if (Optional.ofNullable(row).isPresent()) {
                System.out.println("当前处理 第" + row.getRowNum() + "行:");
                importFacilityNode(row);
            }
            System.out.println("第" + row.getRowNum() + "行 已导入");
        }

        sheet = excel.getSheet("04风险");
        lastRowNum = sheet.getLastRowNum();
        System.out.println("最后行号：" + lastRowNum);
        for (int i = 1; i <= lastRowNum; ++i) {
            XSSFRow row = sheet.getRow(i);
            if (Optional.ofNullable(row).isPresent()) {
                System.out.println("当前处理 第" + row.getRowNum() + "行:");
                importRiskNode(row);
            }
            System.out.println("第" + row.getRowNum() + "行 已导入");
        }

        sheet = excel.getSheet("05行为措施");
        lastRowNum = sheet.getLastRowNum();
        System.out.println("最后行号：" + lastRowNum);
        for (int i = 1; i <= lastRowNum; ++i) {
            XSSFRow row = sheet.getRow(i);
            if (Optional.ofNullable(row).isPresent()) {
                System.out.println("当前处理 第" + row.getRowNum() + "行:");
                importMeasureNode(row);
            }
            System.out.println("第" + row.getRowNum() + "行 已导入");
        }

        sheet = excel.getSheet("02关联");
        lastRowNum = sheet.getLastRowNum();
        System.out.println("最后行号：" + lastRowNum);
        for (int i = 2; i <= lastRowNum; ++i) {
            XSSFRow row = sheet.getRow(i);
            if (Optional.ofNullable(row).isPresent()) {
                System.out.println("当前处理 第" + row.getRowNum() + "行:");
                importAssociationEdge(row);
            }
            System.out.println("第" + row.getRowNum() + "行 已导入");
        }

        sheet = excel.getSheet("03包含");
        lastRowNum = sheet.getLastRowNum();
        System.out.println("最后行号：" + lastRowNum);
        for (int i = 2; i <= lastRowNum; ++i) {
            XSSFRow row = sheet.getRow(i);
            if (Optional.ofNullable(row).isPresent()) {
                System.out.println("当前处理 第" + row.getRowNum() + "行:");
                importCompositionEdge(row);
            }
            System.out.println("第" + row.getRowNum() + "行 已导入");
        }

        sheet = excel.getSheet("06保护");
        lastRowNum = sheet.getLastRowNum();
        System.out.println("最后行号：" + lastRowNum);
        for (int i = 2; i <= lastRowNum; ++i) {
            XSSFRow row = sheet.getRow(i);
            if (Optional.ofNullable(row).isPresent()) {
                System.out.println("当前处理 第" + row.getRowNum() + "行:");
                importProtectEdge(row);
            }
            System.out.println("第" + row.getRowNum() + "行 已导入");
        }

        sheet = excel.getSheet("07因果");
        lastRowNum = sheet.getLastRowNum();
        System.out.println("最后行号：" + lastRowNum);
        for (int i = 2; i <= lastRowNum; ++i) {
            XSSFRow row = sheet.getRow(i);
            if (Optional.ofNullable(row).isPresent()) {
                System.out.println("当前处理 第" + row.getRowNum() + "行:");
                importCausalityEdge(row);
            }
            System.out.println("第" + row.getRowNum() + "行 已导入");
        }

        //5.关闭资源
        excel.close();
        fileInputStream.close();
    }

    private void importCausalityEdge(XSSFRow row) {

        ETRkgnodeA source = null;
        ETRkgnodeA target = null;
        if (Optional.ofNullable(row.getCell(1)).isPresent()) {
            var title = row.getCell(1).getStringCellValue();
            var tn = "";
            if (Optional.ofNullable(row.getCell(2)).isPresent()) {
                tn = row.getCell(2).getStringCellValue();
            }
            ETRkgnodeA node_facility_a = new ETRkgnodeA();
            node_facility_a.setData("{\"title\":\"" + title + "\",\"tn\":\"" + tn + "\"}");
            node_facility_a.setNodeClass("risk");
            source = rKGRepository.selectETRkgnodeAFacilityOne(node_facility_a).orElse(null);
        }

        if (Optional.ofNullable(row.getCell(3)).isPresent()) {
            var title = row.getCell(3).getStringCellValue();
            var tn = "";
            if (Optional.ofNullable(row.getCell(4)).isPresent()) {
                tn = row.getCell(4).getStringCellValue();
            }
            ETRkgnodeA node_facility_a = new ETRkgnodeA();
            node_facility_a.setData("{\"title\":\"" + title + "\",\"tn\":\"" + tn + "\"}");
            node_facility_a.setNodeClass("risk");
            target = rKGRepository.selectETRkgnodeAFacilityOne(node_facility_a).orElse(null);
            if (Optional.ofNullable(target).isEmpty()) {
                node_facility_a.setNodeClass("measure");
                target = rKGRepository.selectETRkgnodeAFacilityOne(node_facility_a).orElse(null);
            }
        }

        if (Optional.ofNullable(source).isPresent() && Optional.ofNullable(target).isPresent()) {
            ETRkgedgeA edge = new ETRkgedgeA();
            edge.setSource(source.getId() + "");
            edge.setTarget(target.getId() + "");
            edge.setStyle("{\"endArrow\":true," +
                    "\"lineWidth\":2," +
                    "\"stroke\":\"#59C4F7\"," +
                    "\"labelText\":\"导致\"}");
            graphService.addEdgeA(edge);
        }
    }

    private void importProtectEdge(XSSFRow row) {

        ETRkgnodeA source = null;
        ETRkgnodeA target = null;
        if (Optional.ofNullable(row.getCell(1)).isPresent()) {
            var title = row.getCell(1).getStringCellValue();
            var tn = "";
            if (Optional.ofNullable(row.getCell(2)).isPresent()) {
                tn = row.getCell(2).getStringCellValue();
            }
            ETRkgnodeA node_facility_a = new ETRkgnodeA();
            node_facility_a.setData("{\"title\":\"" + title + "\",\"tn\":\"" + tn + "\"}");
            node_facility_a.setNodeClass("facility");
            source = rKGRepository.selectETRkgnodeAFacilityOne(node_facility_a).orElse(null);
        }

        if (Optional.ofNullable(row.getCell(3)).isPresent()) {
            var title = row.getCell(3).getStringCellValue();
            var tn = "";
            if (Optional.ofNullable(row.getCell(4)).isPresent()) {
                tn = row.getCell(4).getStringCellValue();
            }
            ETRkgnodeA node_facility_a = new ETRkgnodeA();
            node_facility_a.setData("{\"title\":\"" + title + "\",\"tn\":\"" + tn + "\"}");
            node_facility_a.setNodeClass("risk");
            target = rKGRepository.selectETRkgnodeAFacilityOne(node_facility_a).orElse(null);
        }

        if (Optional.ofNullable(source).isPresent() && Optional.ofNullable(target).isPresent()) {
            ETRkgedgeA edge = new ETRkgedgeA();
            edge.setSource(source.getId() + "");
            edge.setTarget(target.getId() + "");
            edge.setStyle("{\"endArrow\":true," +
                    "\"lineWidth\":2," +
                    "\"stroke\":\"#59C4F7\"," +
                    "\"labelText\":\"保护\"}");
            graphService.addEdgeA(edge);
        }
    }

    private void importCompositionEdge(XSSFRow row) {

        ETRkgnodeA source = null;
        ETRkgnodeA target = null;
        if (Optional.ofNullable(row.getCell(1)).isPresent()) {
            var title = row.getCell(1).getStringCellValue();
            var tn = "";
            if (Optional.ofNullable(row.getCell(2)).isPresent()) {
                tn = row.getCell(2).getStringCellValue();
            }
            ETRkgnodeA node_facility_a = new ETRkgnodeA();
            node_facility_a.setData("{\"title\":\"" + title + "\",\"tn\":\"" + tn + "\"}");
            node_facility_a.setNodeClass("facility");
            source = rKGRepository.selectETRkgnodeAFacilityOne(node_facility_a).orElse(null);
        }

        if (Optional.ofNullable(row.getCell(3)).isPresent()) {
            var title = row.getCell(3).getStringCellValue();
            var tn = "";
            if (Optional.ofNullable(row.getCell(4)).isPresent()) {
                tn = row.getCell(4).getStringCellValue();
            }
            ETRkgnodeA node_facility_a = new ETRkgnodeA();
            node_facility_a.setData("{\"title\":\"" + title + "\",\"tn\":\"" + tn + "\"}");
            node_facility_a.setNodeClass("facility");
            target = rKGRepository.selectETRkgnodeAFacilityOne(node_facility_a).orElse(null);
            if (Optional.ofNullable(target).isEmpty()) {
                node_facility_a.setNodeClass("measure");
                target = rKGRepository.selectETRkgnodeAFacilityOne(node_facility_a).orElse(null);
            }
        }

        if (Optional.ofNullable(source).isPresent() && Optional.ofNullable(target).isPresent()) {
            ETRkgedgeA edge = new ETRkgedgeA();
            edge.setSource(source.getId() + "");
            edge.setTarget(target.getId() + "");
            edge.setStyle("{\"endArrow\":true," +
                    "\"lineWidth\":2," +
                    "\"stroke\":\"#59C4F7\"," +
                    "\"labelText\":\"包含\"}");
            graphService.addEdgeA(edge);
        }
    }

    private void importAssociationEdge(XSSFRow row) {

        ETRkgnodeA source = null;
        ETRkgnodeA target = null;
        if (Optional.ofNullable(row.getCell(1)).isPresent()) {
            var title = row.getCell(1).getStringCellValue();
            var tn = "";
            if (Optional.ofNullable(row.getCell(2)).isPresent()) {
                tn = row.getCell(2).getStringCellValue();
            }
            ETRkgnodeA node_facility_a = new ETRkgnodeA();
            node_facility_a.setData("{\"title\":\"" + title + "\",\"tn\":\"" + tn + "\"}");
            node_facility_a.setNodeClass("facility");
            source = rKGRepository.selectETRkgnodeAFacilityOne(node_facility_a).orElse(null);
        }

        if (Optional.ofNullable(row.getCell(3)).isPresent()) {
            var title = row.getCell(3).getStringCellValue();
            var tn = "";
            if (Optional.ofNullable(row.getCell(4)).isPresent()) {
                tn = row.getCell(4).getStringCellValue();
            }
            ETRkgnodeA node_facility_a = new ETRkgnodeA();
            node_facility_a.setData("{\"title\":\"" + title + "\",\"tn\":\"" + tn + "\"}");
            node_facility_a.setNodeClass("facility");
            target = rKGRepository.selectETRkgnodeAFacilityOne(node_facility_a).orElse(null);
        }

        if (Optional.ofNullable(source).isPresent() && Optional.ofNullable(target).isPresent()) {
            ETRkgedgeA edge = new ETRkgedgeA();
            edge.setSource(source.getId() + "");
            edge.setTarget(target.getId() + "");
            edge.setStyle("{\"endArrow\":false," +
                    "\"lineWidth\":2," +
                    "\"stroke\":\"#59C4F7\"," +
                    "\"labelText\":\"关联\"}");
            graphService.addEdgeA(edge);
        }
    }

    private void importMeasureNode(XSSFRow row) {
        if (Optional.ofNullable(row.getCell(0)).isPresent()) {
            var title = row.getCell(0).getStringCellValue();
            var tn = "";
            if (Optional.ofNullable(row.getCell(1)).isPresent()) {
                tn = row.getCell(1).getStringCellValue();
            }
            ETRkgnodeA node_facility_a = new ETRkgnodeA();
            node_facility_a.setData("{\"title\":\"" + title + "\",\"tn\":\"" + tn + "\"}");
            node_facility_a.setNodeClass("measure");
            node_facility_a.setStyle("{\"fill\":\"#59C4F7\"}");
            node_facility_a.setType("circle");
            graphService.addNodeA(node_facility_a);
        }
    }

    private void importRiskNode(XSSFRow row) {
        if (Optional.ofNullable(row.getCell(0)).isPresent()) {
            var title = row.getCell(0).getStringCellValue();
            var tn = "";
            if (Optional.ofNullable(row.getCell(1)).isPresent()) {
                tn = row.getCell(1).getStringCellValue();
            }
            ETRkgnodeA node_facility_a = new ETRkgnodeA();
            node_facility_a.setData("{\"title\":\"" + title + "\",\"tn\":\"" + tn + "\"}");
            node_facility_a.setNodeClass("risk");
            node_facility_a.setStyle("{\"fill\":\"#00C691\"}");
            node_facility_a.setType("circle");
            graphService.addNodeA(node_facility_a);
        }
    }


    private void importFacilityNode(XSSFRow row) {

        if (Optional.ofNullable(row.getCell(0)).isPresent()) {
            var title = row.getCell(0).getStringCellValue();
            var tn = "";
            if (Optional.ofNullable(row.getCell(1)).isPresent()) {
                tn = row.getCell(1).getStringCellValue();
            }
            ETRkgnodeA node_facility_a = new ETRkgnodeA();
            node_facility_a.setData("{\"title\":\"" + title + "\",\"tn\":\"" + tn + "\"}");
            node_facility_a.setNodeClass("facility");
            node_facility_a.setStyle("{\"fill\":\"#4F85F6\"}");
            node_facility_a.setType("rect");
            graphService.addNodeA(node_facility_a);
        }
    }


}
