package com.greatech.server.rkg.service;


import com.greatech.server.rkg.pojo.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ImportService {

    //主体
    ETFacility selectOrAddETFacility(ETFacility record);

    //事件
    ETEvent selectOrAddETEvent(ETEvent record);

    //主体事件关系
    RTFacilityEvent selectOrAddRTFacilityEvent(ETFacility facility, ETEvent event);

    //风险
    ETRisk selectOrAddETRisk(ETRisk record);

    //风险事件关系
    RTRiskEvent selectOrAddRTRiskEvent(ETRisk risk, ETEvent event);

    //措施
    ETMeasure selectOrAddETMeasure(ETMeasure record);

    //风险的措施
    RTRiskMeasure selectOrAddRTRiskMeasure(ETRisk risk, ETMeasure measure);

    //原因
    ETReason selectOrAddETReason(ETReason record);

    //原因的事件
    RTReasonEvent selectOrAddRTReasonEvent(ETReason reason, ETEvent event);

    //风险的原因
    RTRiskReason selectOrAddRTRiskReason(ETRisk risk, ETReason reason);

    //后果
    ETResult selectOrAddETResult(ETResult record);

    //后果的事件
    RTResultEvent selectOrAddRTResultEvent(ETResult result, ETEvent event);

    //风险的后果
    RTRiskResult selectOrAddRTRiskResult(ETRisk risk, ETResult result);




}
