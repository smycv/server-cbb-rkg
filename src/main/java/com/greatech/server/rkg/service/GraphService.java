package com.greatech.server.rkg.service;

import com.greatech.server.rkg.pojo.ETRkgedge;
import com.greatech.server.rkg.pojo.ETRkgedgeA;
import com.greatech.server.rkg.pojo.ETRkgnode;
import com.greatech.server.rkg.pojo.ETRkgnodeA;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GraphService {

    ETRkgnode addNode(ETRkgnode record);

    ETRkgnodeA addNodeA(ETRkgnodeA record);

    ETRkgedge addEdge(ETRkgedge record);

    ETRkgedgeA addEdgeA(ETRkgedgeA record);


    List<ETRkgnodeA> findNodeA();

    List<ETRkgnodeA> findNodeB();

    List<ETRkgedgeA> findEdgeA();

    List<ETRkgedgeA> findEdgeB();
}
