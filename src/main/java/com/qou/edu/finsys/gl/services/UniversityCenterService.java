package com.qou.edu.finsys.gl.services;


import com.qou.edu.finsys.gl.dtos.UniversityCenterDTO;
import com.qou.edu.finsys.gl.payloads.UniversityCenterResponse;

public interface UniversityCenterService {
	UniversityCenterResponse getAllCentersInfo(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);
	
	UniversityCenterDTO getCenterBYId(Long centerId);

	UniversityCenterDTO updateCenter(Long centerId, UniversityCenterDTO centersDTO);
	
	String deleteCenter(Long centerId);
}
