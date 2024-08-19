package com.greatech.server.rkg.service;

import com.greatech.server.rkg.pojo.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RiskService {

    List<RTRiskReason> findCurrentRiskByReason(ETReason record);

    Long findOtherRiskByReason(ETReason record);

    List<RTRiskResult> findCurrentRiskByResult(ETResult record);

    Long findOtherRiskByResult(ETResult record);

    RTRiskEvent findRTRiskEvent(ETRisk record);
}
