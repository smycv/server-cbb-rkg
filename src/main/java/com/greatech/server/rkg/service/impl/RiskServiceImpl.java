package com.greatech.server.rkg.service.impl;

import com.greatech.server.rkg.dao.*;
import com.greatech.server.rkg.pojo.*;
import com.greatech.server.rkg.service.RiskService;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualToWhenPresent;
import static org.mybatis.dynamic.sql.SqlBuilder.select;

@Service
public class RiskServiceImpl implements RiskService {


    @Autowired
    RTReasonEventMapper rTReasonEventMapper;

    @Autowired
    RTRiskEventMapper rTRiskEventMapper;

    @Autowired
    RTRiskReasonMapper rTRiskReasonMapper;

    @Override
    public List<RTRiskReason> findCurrentRiskByReason(ETReason record) {

        SelectStatementProvider sqlDsl = select(RTRiskReasonDynamicSqlSupport.RTRiskReason.allColumns())
                .from(RTRiskReasonDynamicSqlSupport.RTRiskReason)
                .where(RTRiskReasonDynamicSqlSupport.RTRiskReason.reasonId, isEqualToWhenPresent(record.getId()))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return rTRiskReasonMapper.selectMany(sqlDsl);
    }

    @Override
    public Long findOtherRiskByReason(ETReason record) {

        SelectStatementProvider sqlDsl = select(RTReasonEventDynamicSqlSupport.RTReasonEvent.allColumns())
                .from(RTReasonEventDynamicSqlSupport.RTReasonEvent)
                .where(RTReasonEventDynamicSqlSupport.RTReasonEvent.reasonId, isEqualToWhenPresent(record.getId()))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        Optional<RTReasonEvent> rTReasonEvent = rTReasonEventMapper.selectOne(sqlDsl);
        if (rTReasonEvent.isPresent()) {
            SelectStatementProvider sqlDsl2 = select(RTRiskEventDynamicSqlSupport.RTRiskEvent.allColumns())
                    .from(RTRiskEventDynamicSqlSupport.RTRiskEvent)
                    .where(RTRiskEventDynamicSqlSupport.RTRiskEvent.eventId, isEqualToWhenPresent(rTReasonEvent.get().getEventId()))
                    .build()
                    .render(RenderingStrategies.MYBATIS3);
            Optional<RTRiskEvent> rTRiskEvent = rTRiskEventMapper.selectOne(sqlDsl2);
            if (rTRiskEvent.isPresent()) {
                return rTRiskEvent.get().getRiskId();
            }
        }

        return null;
    }

    @Autowired
    RTRiskResultMapper rTRiskResultMapper;

    @Autowired
    RTResultEventMapper rTResultEventMapper;

    @Override
    public List<RTRiskResult> findCurrentRiskByResult(ETResult record) {

        SelectStatementProvider sqlDsl = select(RTRiskResultDynamicSqlSupport.RTRiskResult.allColumns())
                .from(RTRiskResultDynamicSqlSupport.RTRiskResult)
                .where(RTRiskResultDynamicSqlSupport.RTRiskResult.resultId, isEqualToWhenPresent(record.getId()))
                .build()
                .render(RenderingStrategies.MYBATIS3);

        return rTRiskResultMapper.selectMany(sqlDsl);

    }

    @Override
    public Long findOtherRiskByResult(ETResult record) {

        SelectStatementProvider sqlDsl = select(RTResultEventDynamicSqlSupport.RTResultEvent.allColumns())
                .from(RTResultEventDynamicSqlSupport.RTResultEvent)
                .where(RTResultEventDynamicSqlSupport.RTResultEvent.resultId, isEqualToWhenPresent(record.getId()))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        Optional<RTResultEvent> rTResultEvent = rTResultEventMapper.selectOne(sqlDsl);
        if (rTResultEvent.isPresent()) {
            SelectStatementProvider sqlDsl2 = select(RTRiskEventDynamicSqlSupport.RTRiskEvent.allColumns())
                    .from(RTRiskEventDynamicSqlSupport.RTRiskEvent)
                    .where(RTRiskEventDynamicSqlSupport.RTRiskEvent.eventId, isEqualToWhenPresent(rTResultEvent.get().getEventId()))
                    .build()
                    .render(RenderingStrategies.MYBATIS3);
            Optional<RTRiskEvent> rTRiskEvent = rTRiskEventMapper.selectOne(sqlDsl2);
            if (rTRiskEvent.isPresent()) {
                return rTRiskEvent.get().getRiskId();
            }
        }

        return null;
    }

    @Override
    public RTRiskEvent findRTRiskEvent(ETRisk record) {
        SelectStatementProvider sqlDsl = select(RTRiskEventDynamicSqlSupport.RTRiskEvent.allColumns())
                .from(RTRiskEventDynamicSqlSupport.RTRiskEvent)
                .where(RTRiskEventDynamicSqlSupport.RTRiskEvent.riskId, isEqualToWhenPresent(record.getId()))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        Optional<RTRiskEvent> rTRiskEvent = rTRiskEventMapper.selectOne(sqlDsl);
        return rTRiskEvent.orElse(null);
    }

    @Autowired
    ETEventMapper eTEventMapper;

    @Override
    public ETEvent findEvent(ETRisk record) {
        RTRiskEvent r=findRTRiskEvent(record);
        SelectStatementProvider sqlDsl = select(ETEventDynamicSqlSupport.ETEvent.allColumns())
                .from(ETEventDynamicSqlSupport.ETEvent)
                .where(ETEventDynamicSqlSupport.ETEvent.id, isEqualToWhenPresent(r.getEventId()))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        Optional<ETEvent> event=eTEventMapper.selectOne(sqlDsl);
        return event.orElse(null);
    }
}
