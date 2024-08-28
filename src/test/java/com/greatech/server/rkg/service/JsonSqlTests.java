package com.greatech.server.rkg.service;

import com.greatech.server.rkg.RKGApplication;
import com.greatech.server.rkg.pojo.ETRkgnodeA;
import com.greatech.server.rkg.repository.RKGRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest(classes = RKGApplication.class)
public class JsonSqlTests {

    @Autowired
    RKGRepository rKGRepository;

    @Test
    void test(){
        ETRkgnodeA r = new ETRkgnodeA();
        r.setNodeClass("risk");
        r.setData("{\"risk\":\"粗裂解汽油/6''-P-70001流量上升(FIC70005)\"}");
        r.setStyle("{\"fill\":\"#00C691\"}");
        r.setType("circle");
        Optional<ETRkgnodeA> o= rKGRepository.selectETRkgnodeAOne(r);
        System.out.println(o.get());
    }

}
