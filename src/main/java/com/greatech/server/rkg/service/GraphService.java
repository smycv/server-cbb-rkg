package com.greatech.server.rkg.service;

import com.greatech.server.rkg.pojo.ETRkgedge;
import com.greatech.server.rkg.pojo.ETRkgnode;
import org.springframework.stereotype.Service;

@Service
public interface GraphService {

    ETRkgnode addNode(ETRkgnode record);

    ETRkgedge addEdge(ETRkgedge record);

}
