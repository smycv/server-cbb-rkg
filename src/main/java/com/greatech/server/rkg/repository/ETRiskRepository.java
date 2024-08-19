package com.greatech.server.rkg.repository;

import org.apache.ibatis.annotations.Update;


public interface ETRiskRepository {
    @Update("ALTER TABLE `e_t_risk` AUTO_INCREMENT = #{index}")
    int initAutoIncrement(int index);
}
