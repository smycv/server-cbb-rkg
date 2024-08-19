package com.greatech.server.rkg.service.impl;


import com.greatech.server.rkg.dao.*;
import com.greatech.server.rkg.pojo.*;
import com.greatech.server.rkg.service.ImportService;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualToWhenPresent;
import static org.mybatis.dynamic.sql.SqlBuilder.select;

@Service
public class ImportServiceImpl implements ImportService {


    @Autowired
    ETFacilityMapper eTFacilityMapper;

    @Override
    public ETFacility selectOrAddETFacility(ETFacility record) {

        SelectStatementProvider sqlDsl = select(ETFacilityDynamicSqlSupport.ETFacility.allColumns())
                .from(ETFacilityDynamicSqlSupport.ETFacility)
                //位号不可重复
                .where(ETFacilityDynamicSqlSupport.ETFacility.tn, isEqualToWhenPresent(record.getTn()))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        Optional<ETFacility> facility = eTFacilityMapper.selectOne(sqlDsl);
        if (facility.isPresent()) {
            return facility.get();
        }

        eTFacilityMapper.insertSelective(record);
        facility = eTFacilityMapper.selectOne(sqlDsl);
        if (facility.isPresent()) {
            return facility.get();
        }

        throw new RuntimeException();
    }

    @Autowired
    ETEventMapper eTEventMapper;

    @Override
    public ETEvent selectOrAddETEvent(ETFacility facility, ETEvent record) {
        SelectStatementProvider sqlDsl = select(ETEventDynamicSqlSupport.ETEvent.allColumns())
                .from(ETEventDynamicSqlSupport.ETEvent)
                .where(ETEventDynamicSqlSupport.ETEvent.determine, isEqualToWhenPresent(record.getDetermine()))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        Optional<ETEvent> event = eTEventMapper.selectOne(sqlDsl);
        if (event.isPresent()) {//有事件
            SelectStatementProvider sqlDsl4facility = select(RTFacilityEventDynamicSqlSupport.RTFacilityEvent.allColumns())
                    .from(RTFacilityEventDynamicSqlSupport.RTFacilityEvent)
                    .where(RTFacilityEventDynamicSqlSupport.RTFacilityEvent.facilityId, isEqualToWhenPresent(facility.getId()))
                    .and(RTFacilityEventDynamicSqlSupport.RTFacilityEvent.eventId, isEqualToWhenPresent(event.get().getId()))
                    .build()
                    .render(RenderingStrategies.MYBATIS3);
            Optional<RTFacilityEvent> r = rTFacilityEventMapper.selectOne(sqlDsl4facility);
            if (r.isPresent()) {//主体事件都一致 不新增事件
                return event.get();
            }
        }

        eTEventMapper.insertSelective(record);
        event = eTEventMapper.selectOne(sqlDsl);
        if (event.isPresent()) {
            return event.get();
        }

        throw new RuntimeException();
    }

    @Autowired
    RTFacilityEventMapper rTFacilityEventMapper;

    @Override
    public RTFacilityEvent selectOrAddRTFacilityEvent(ETFacility facility, ETEvent event) {
        RTFacilityEvent record = new RTFacilityEvent();
        record.setFacilityId(facility.getId());
        record.setEventId(event.getId());

        SelectStatementProvider sqlDsl = select(RTFacilityEventDynamicSqlSupport.RTFacilityEvent.allColumns())
                .from(RTFacilityEventDynamicSqlSupport.RTFacilityEvent)
                .where(RTFacilityEventDynamicSqlSupport.RTFacilityEvent.facilityId, isEqualToWhenPresent(record.getFacilityId()))
                .and(RTFacilityEventDynamicSqlSupport.RTFacilityEvent.eventId, isEqualToWhenPresent(record.getEventId()))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        Optional<RTFacilityEvent> r = rTFacilityEventMapper.selectOne(sqlDsl);
        if (r.isPresent()) {
            return r.get();
        }

        rTFacilityEventMapper.insertSelective(record);
        r = rTFacilityEventMapper.selectOne(sqlDsl);
        if (r.isPresent()) {
            return r.get();
        }

        throw new RuntimeException();
    }

    @Autowired
    ETRiskMapper eTRiskMapper;

    @Override
    public ETRisk selectOrAddETRisk(ETRisk record) {

        SelectStatementProvider sqlDsl = select(ETRiskDynamicSqlSupport.ETRisk.allColumns())
                .from(ETRiskDynamicSqlSupport.ETRisk)
                .where(ETRiskDynamicSqlSupport.ETRisk.content, isEqualToWhenPresent(record.getContent()))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        Optional<ETRisk> risk = eTRiskMapper.selectOne(sqlDsl);

        if (risk.isPresent()) {
            return risk.get();
        }

        eTRiskMapper.insertSelective(record);
        risk = eTRiskMapper.selectOne(sqlDsl);
        if (risk.isPresent()) {
            return risk.get();
        }

        throw new RuntimeException();
    }

    @Autowired
    RTRiskEventMapper rTRiskEventMapper;

    @Override
    public RTRiskEvent selectOrAddRTRiskEvent(ETRisk risk, ETEvent event) {
        RTRiskEvent record = new RTRiskEvent();
        record.setRiskId(risk.getId());
        record.setEventId(event.getId());

        SelectStatementProvider sqlDsl = select(RTRiskEventDynamicSqlSupport.RTRiskEvent.allColumns())
                .from(RTRiskEventDynamicSqlSupport.RTRiskEvent)
                .where(RTRiskEventDynamicSqlSupport.RTRiskEvent.riskId, isEqualToWhenPresent(record.getRiskId()))
                .and(RTRiskEventDynamicSqlSupport.RTRiskEvent.eventId, isEqualToWhenPresent(record.getEventId()))
                .build()
                .render(RenderingStrategies.MYBATIS3);

        Optional<RTRiskEvent> r = rTRiskEventMapper.selectOne(sqlDsl);


        if (r.isPresent()) {
            return r.get();
        }

        rTRiskEventMapper.insertSelective(record);
        r = rTRiskEventMapper.selectOne(sqlDsl);
        if (r.isPresent()) {
            return r.get();
        }

        throw new RuntimeException();
    }

    @Autowired
    ETMeasureMapper eTMeasureMapper;

    @Override
    public ETMeasure selectOrAddETMeasure(ETMeasure record) {

        SelectStatementProvider sqlDsl = select(ETMeasureDynamicSqlSupport.ETMeasure.allColumns())
                .from(ETMeasureDynamicSqlSupport.ETMeasure)
                .where(ETMeasureDynamicSqlSupport.ETMeasure.content, isEqualToWhenPresent(record.getContent()))
                .build()
                .render(RenderingStrategies.MYBATIS3);

        Optional<ETMeasure> measure = eTMeasureMapper.selectOne(sqlDsl);

        if (measure.isPresent()) {
            return measure.get();
        }

        eTMeasureMapper.insertSelective(record);
        measure = eTMeasureMapper.selectOne(sqlDsl);
        if (measure.isPresent()) {
            return measure.get();
        }

        throw new RuntimeException();
    }

    @Autowired
    RTRiskMeasureMapper rTRiskMeasureMapper;

    @Override
    public RTRiskMeasure selectOrAddRTRiskMeasure(ETRisk risk, ETMeasure measure) {
        RTRiskMeasure record = new RTRiskMeasure();
        record.setRiskId(risk.getId());
        record.setMeasureId(measure.getId());

        SelectStatementProvider sqlDsl = select(RTRiskMeasureDynamicSqlSupport.RTRiskMeasure.allColumns())
                .from(RTRiskMeasureDynamicSqlSupport.RTRiskMeasure)
                .where(RTRiskMeasureDynamicSqlSupport.RTRiskMeasure.riskId, isEqualToWhenPresent(record.getRiskId()))
                .and(RTRiskMeasureDynamicSqlSupport.RTRiskMeasure.measureId, isEqualToWhenPresent(record.getMeasureId()))
                .build()
                .render(RenderingStrategies.MYBATIS3);


        Optional<RTRiskMeasure> r = rTRiskMeasureMapper.selectOne(sqlDsl);

        if (r.isPresent()) {
            return r.get();
        }

        rTRiskMeasureMapper.insertSelective(record);
        r = rTRiskMeasureMapper.selectOne(sqlDsl);
        if (r.isPresent()) {
            return r.get();
        }

        throw new RuntimeException();
    }

    @Autowired
    ETReasonMapper eTReasonMapper;

    @Override
    public ETReason selectOrAddETReason(ETReason record) {

        SelectStatementProvider sqlDsl = select(ETReasonDynamicSqlSupport.ETReason.allColumns())
                .from(ETReasonDynamicSqlSupport.ETReason)
                .where(ETReasonDynamicSqlSupport.ETReason.content, isEqualToWhenPresent(record.getContent()))
                .build()
                .render(RenderingStrategies.MYBATIS3);

        Optional<ETReason> reason = eTReasonMapper.selectOne(sqlDsl);

        if (reason.isPresent()) {
            return reason.get();
        }

        eTReasonMapper.insertSelective(record);
        reason = eTReasonMapper.selectOne(sqlDsl);
        if (reason.isPresent()) {
            return reason.get();
        }

        throw new RuntimeException();
    }

    @Autowired
    RTReasonEventMapper rTReasonEventMapper;

    @Override
    public RTReasonEvent selectOrAddRTReasonEvent(ETReason reason, ETEvent event) {
        RTReasonEvent record = new RTReasonEvent();
        record.setReasonId(reason.getId());
        record.setEventId(event.getId());

        SelectStatementProvider sqlDsl = select(RTReasonEventDynamicSqlSupport.RTReasonEvent.allColumns())
                .from(RTReasonEventDynamicSqlSupport.RTReasonEvent)
                .where(RTReasonEventDynamicSqlSupport.RTReasonEvent.reasonId, isEqualToWhenPresent(record.getReasonId()))
                .and(RTReasonEventDynamicSqlSupport.RTReasonEvent.eventId, isEqualToWhenPresent(record.getEventId()))
                .build()
                .render(RenderingStrategies.MYBATIS3);

        Optional<RTReasonEvent> r = rTReasonEventMapper.selectOne(sqlDsl);

        if (r.isPresent()) {
            return r.get();
        }

        rTReasonEventMapper.insertSelective(record);
        r = rTReasonEventMapper.selectOne(sqlDsl);
        if (r.isPresent()) {
            return r.get();
        }

        throw new RuntimeException();
    }

    @Autowired
    RTRiskReasonMapper rTRiskReasonMapper;

    @Override
    public RTRiskReason selectOrAddRTRiskReason(ETRisk risk, ETReason reason) {
        RTRiskReason record = new RTRiskReason();
        record.setRiskId(risk.getId());
        record.setReasonId(reason.getId());

        SelectStatementProvider sqlDsl = select(RTRiskReasonDynamicSqlSupport.RTRiskReason.allColumns())
                .from(RTRiskReasonDynamicSqlSupport.RTRiskReason)
                .where(RTRiskReasonDynamicSqlSupport.RTRiskReason.reasonId, isEqualToWhenPresent(record.getReasonId()))
                .and(RTRiskReasonDynamicSqlSupport.RTRiskReason.riskId, isEqualToWhenPresent(record.getRiskId()))
                .build()
                .render(RenderingStrategies.MYBATIS3);

        Optional<RTRiskReason> r = rTRiskReasonMapper.selectOne(sqlDsl);

        if (r.isPresent()) {
            return r.get();
        }

        rTRiskReasonMapper.insertSelective(record);
        r = rTRiskReasonMapper.selectOne(sqlDsl);
        if (r.isPresent()) {
            return r.get();
        }

        throw new RuntimeException();
    }

    @Autowired
    ETResultMapper eTResultMapper;

    @Override
    public ETResult selectOrAddETResult(ETResult record) {

        SelectStatementProvider sqlDsl = select(ETResultDynamicSqlSupport.ETResult.allColumns())
                .from(ETResultDynamicSqlSupport.ETResult)
                .where(ETResultDynamicSqlSupport.ETResult.content, isEqualToWhenPresent(record.getContent()))
                .build()
                .render(RenderingStrategies.MYBATIS3);

        Optional<ETResult> result = eTResultMapper.selectOne(sqlDsl);

        if (result.isPresent()) {
            return result.get();
        }

        eTResultMapper.insertSelective(record);
        result = eTResultMapper.selectOne(sqlDsl);
        if (result.isPresent()) {
            return result.get();
        }

        throw new RuntimeException();
    }

    @Autowired
    RTResultEventMapper rTResultEventMapper;

    @Override
    public RTResultEvent selectOrAddRTResultEvent(ETResult result, ETEvent event) {
        RTResultEvent record = new RTResultEvent();
        record.setResultId(result.getId());
        record.setEventId(event.getId());

        SelectStatementProvider sqlDsl = select(RTResultEventDynamicSqlSupport.RTResultEvent.allColumns())
                .from(RTResultEventDynamicSqlSupport.RTResultEvent)
                .where(RTResultEventDynamicSqlSupport.RTResultEvent.resultId, isEqualToWhenPresent(result.getId()))
                .and(RTReasonEventDynamicSqlSupport.RTReasonEvent.eventId, isEqualToWhenPresent(record.getEventId()))
                .build()
                .render(RenderingStrategies.MYBATIS3);


        Optional<RTResultEvent> r = rTResultEventMapper.selectOne(sqlDsl);

        if (r.isPresent()) {
            return r.get();
        }

        rTResultEventMapper.insertSelective(record);
        r = rTResultEventMapper.selectOne(sqlDsl);
        if (r.isPresent()) {
            return r.get();
        }

        throw new RuntimeException();
    }

    @Autowired
    RTRiskResultMapper rTRiskResultMapper;

    @Override
    public RTRiskResult selectOrAddRTRiskResult(ETRisk risk, ETResult result) {
        RTRiskResult record = new RTRiskResult();
        record.setRiskId(risk.getId());
        record.setResultId(result.getId());

        SelectStatementProvider sqlDsl = select(RTRiskResultDynamicSqlSupport.RTRiskResult.allColumns())
                .from(RTRiskResultDynamicSqlSupport.RTRiskResult)
                .where(RTRiskResultDynamicSqlSupport.RTRiskResult.resultId, isEqualToWhenPresent(record.getResultId()))
                .and(RTRiskReasonDynamicSqlSupport.RTRiskReason.riskId, isEqualToWhenPresent(record.getRiskId()))
                .build()
                .render(RenderingStrategies.MYBATIS3);


        Optional<RTRiskResult> r = rTRiskResultMapper.selectOne(sqlDsl);

        if (r.isPresent()) {
            return r.get();
        }

        rTRiskResultMapper.insertSelective(record);
        r = rTRiskResultMapper.selectOne(sqlDsl);
        if (r.isPresent()) {
            return r.get();
        }

        throw new RuntimeException();
    }

}
