package com.greatech.server.rkg.repository;

import com.greatech.server.rkg.pojo.ETRkgedgeA;
import com.greatech.server.rkg.pojo.ETRkgnodeA;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Optional;

public interface RKGRepository {

    @Select("select * from e_t_rkgnode_a where node_class = #{nodeClass} and data = CAST(#{data} as JSON) and type = #{type} and style = CAST(#{style} as JSON)")
    Optional<ETRkgnodeA> selectETRkgnodeAOne(ETRkgnodeA record);

    @Select("select * from e_t_rkgnode_a where node_class = #{nodeClass} and data = CAST(#{data} as JSON)")
    Optional<ETRkgnodeA> selectETRkgnodeAFacilityOne(ETRkgnodeA record);

    @Select("select * from e_t_rkgedge_a where source = #{source} and target = #{target} and style = CAST(#{style} as JSON)")
    Optional<ETRkgedgeA> selectETRkgedgeAOne(ETRkgedgeA record);


    @Update("update e_t_rkgnode_a set style = JSON_SET(style, \"$.fill\", \"#DE789D\") where id = #{id}")
    void changeNodeAcolorRed(Long id);

    @Update("update e_t_rkgnode_a set style = JSON_SET(style, \"$.fill\", \"#00C691\") where id = #{id}")
    void changeNodeAcolorGreen(Long id);
}
