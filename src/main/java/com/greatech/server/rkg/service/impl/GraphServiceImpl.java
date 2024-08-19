package com.greatech.server.rkg.service.impl;

import com.greatech.server.rkg.dao.ETRkgedgeDynamicSqlSupport;
import com.greatech.server.rkg.dao.ETRkgedgeMapper;
import com.greatech.server.rkg.dao.ETRkgnodeDynamicSqlSupport;
import com.greatech.server.rkg.dao.ETRkgnodeMapper;
import com.greatech.server.rkg.pojo.ETRkgedge;
import com.greatech.server.rkg.pojo.ETRkgnode;
import com.greatech.server.rkg.service.GraphService;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualToWhenPresent;
import static org.mybatis.dynamic.sql.SqlBuilder.select;

@Service
public class GraphServiceImpl implements GraphService {


    @Autowired
    ETRkgnodeMapper eTRkgnodeMapper;

    @Autowired
    ETRkgedgeMapper eTRkgedgeMapper;

    @Override
    public ETRkgnode addNode(ETRkgnode record) {
        //查询，已经有了查出来返回
        SelectStatementProvider sqlDsl = select(ETRkgnodeDynamicSqlSupport.ETRkgnode.allColumns())
                .from(ETRkgnodeDynamicSqlSupport.ETRkgnode)
                .where(ETRkgnodeDynamicSqlSupport.ETRkgnode.name, isEqualToWhenPresent(record.getName()))
                .and(ETRkgnodeDynamicSqlSupport.ETRkgnode.obj, isEqualToWhenPresent(record.getObj()))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        Optional<ETRkgnode> node = eTRkgnodeMapper.selectOne(sqlDsl);
        if (node.isPresent()) {
            return node.get();
        }
        //如果没有，新增后查询返回
        eTRkgnodeMapper.insertSelective(record);
        node = eTRkgnodeMapper.selectOne(sqlDsl);
        if (node.isPresent()) {
            return node.get();
        }
        //新增后查不出来 抛异常
        throw new RuntimeException();
    }

    @Override
    public ETRkgedge addEdge(ETRkgedge record) {
        //查询，已经有了查出来返回
        SelectStatementProvider sqlDsl = select(ETRkgedgeDynamicSqlSupport.ETRkgedge.allColumns())
                .from(ETRkgedgeDynamicSqlSupport.ETRkgedge)
                .where(ETRkgedgeDynamicSqlSupport.ETRkgedge.source, isEqualToWhenPresent(record.getSource()))
                .and(ETRkgedgeDynamicSqlSupport.ETRkgedge.target, isEqualToWhenPresent(record.getTarget()))
                .and(ETRkgedgeDynamicSqlSupport.ETRkgedge.tag, isEqualToWhenPresent(record.getTag()))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        Optional<ETRkgedge> edge = eTRkgedgeMapper.selectOne(sqlDsl);
        if (edge.isPresent()) {
            return edge.get();
        }
        //如果没有，新增后查询返回
        eTRkgedgeMapper.insertSelective(record);
        edge = eTRkgedgeMapper.selectOne(sqlDsl);
        if (edge.isPresent()) {
            return edge.get();
        }
        //新增后查不出来 抛异常
        throw new RuntimeException();
    }

}
