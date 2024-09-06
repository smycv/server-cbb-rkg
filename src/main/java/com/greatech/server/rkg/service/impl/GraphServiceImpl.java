package com.greatech.server.rkg.service.impl;

import com.greatech.server.rkg.dao.*;
import com.greatech.server.rkg.pojo.ETRkgedge;
import com.greatech.server.rkg.pojo.ETRkgedgeA;
import com.greatech.server.rkg.pojo.ETRkgnode;
import com.greatech.server.rkg.pojo.ETRkgnodeA;
import com.greatech.server.rkg.repository.RKGRepository;
import com.greatech.server.rkg.service.GraphService;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.function.Cast;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

@Service
public class GraphServiceImpl implements GraphService {


    @Autowired
    ETRkgnodeMapper eTRkgnodeMapper;

    @Autowired
    ETRkgnodeAMapper eTRkgnodeAMapper;

    @Autowired
    ETRkgedgeMapper eTRkgedgeMapper;

    @Autowired
    ETRkgedgeAMapper eTRkgedgeAMapper;

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

    @Autowired
    RKGRepository rKGRepository;

    @Override
    public ETRkgnodeA addNodeA(ETRkgnodeA record) {
        Optional<ETRkgnodeA> node = rKGRepository.selectETRkgnodeAOne(record);
        if (node.isPresent()) {
            return node.get();
        }
        //如果没有，新增后查询返回
        eTRkgnodeAMapper.insertSelective(record);
        node = rKGRepository.selectETRkgnodeAOne(record);
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

    @Override
    public ETRkgedgeA addEdgeA(ETRkgedgeA record) {
        Optional<ETRkgedgeA> edge = rKGRepository.selectETRkgedgeAOne(record);
        if (edge.isPresent()) {
            return edge.get();
        }
        //如果没有，新增后查询返回
        eTRkgedgeAMapper.insertSelective(record);
        edge = rKGRepository.selectETRkgedgeAOne(record);
        if (edge.isPresent()) {
            return edge.get();
        }
        //新增后查不出来 抛异常
        throw new RuntimeException();
    }

    @Override
    public List<ETRkgnodeA> findNodeA() {

        SelectStatementProvider sqlDsl = select(ETRkgnodeADynamicSqlSupport.ETRkgnodeA.allColumns())
                .from(ETRkgnodeADynamicSqlSupport.ETRkgnodeA)
                .where(ETRkgnodeADynamicSqlSupport.ETRkgnodeA.nodeClass, isEqualToWhenPresent("risk"))
//                .or(ETRkgnodeADynamicSqlSupport.ETRkgnodeA.nodeClass, isEqualToWhenPresent("facility"))
                .build()
                .render(RenderingStrategies.MYBATIS3);

        return eTRkgnodeAMapper.selectMany(sqlDsl);
    }

    @Override
    public List<ETRkgedgeA> findEdgeA() {

        SelectStatementProvider sqlDsl = select(ETRkgedgeADynamicSqlSupport.ETRkgedgeA.allColumns())
                .from(ETRkgedgeADynamicSqlSupport.ETRkgedgeA)
                .where(SqlColumn.of("style -> '$.labelText'", SqlTable.of("e_t_rkgedge_a")), isEqualToWhenPresent("风险导致风险(后果)"))
//                .or(SqlColumn.of("style -> '$.labelText'", SqlTable.of("e_t_rkgedge_a")), isEqualToWhenPresent("风险的主体"))
                .build()
                .render(RenderingStrategies.MYBATIS3);

//        System.out.println(sqlDsl_.getSelectStatement());

        return eTRkgedgeAMapper.selectMany(sqlDsl);
    }


}
