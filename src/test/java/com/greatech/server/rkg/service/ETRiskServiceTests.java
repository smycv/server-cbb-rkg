package com.greatech.server.rkg.service;


import com.greatech.server.rkg.RKGApplication;
import com.greatech.server.rkg.dao.ETRiskMapper;
import com.greatech.server.rkg.pojo.ETRisk;
import com.greatech.server.rkg.repository.ETRiskRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.Date;


@SpringBootTest(classes = RKGApplication.class)
public class ETRiskServiceTests {


    @Autowired
    ETRiskMapper eTRiskMapper;

    @Autowired
    ETRiskRepository eTRiskRepository;

    @Test
    @Rollback(value = false)
    void eTRiskMapperTest() {
        ETRisk record = new ETRisk();
        record.setId(1L);
        record.setContent("风险&危险事件");
        record.setCreateTime(new Date());
        var result = eTRiskMapper.insert(record);
//        var result = eTRiskMapper.updateByPrimaryKey(record);
        Assertions.assertTrue(result > 0);
    }

    @Test
    @Rollback(value = false)
    void eTRiskRepositoryTest() {
        var result = eTRiskRepository.initAutoIncrement(0);
        Assertions.assertTrue(result == 0);
    }

}
