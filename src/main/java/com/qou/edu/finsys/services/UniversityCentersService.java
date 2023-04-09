package com.qou.edu.finsys.services;


import com.qou.edu.finsys.payloads.EntityResponse;
import com.qou.edu.finsys.payloads.UniversityCentersDTO;
import com.qou.edu.finsys.payloads.UniversityInfoDTO;

public interface UniversityCentersService {
	EntityResponse getCenterInfo(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);
	
	EntityResponse getCenterBYId(Long centerId);
	
	EntityResponse updateCenter(Long centerId, UniversityCentersDTO centersDTO);
	
	String deleteCenter(Long centerId);
}
