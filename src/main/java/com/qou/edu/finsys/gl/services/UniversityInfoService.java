package com.qou.edu.finsys.gl.services;


import com.qou.edu.finsys.gl.dtos.UniversityInfoDTO;
import com.qou.edu.finsys.gl.payloads.UniversityInfoResponse;

public interface UniversityInfoService {
	UniversityInfoResponse getAllUniversitiesInfo(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

	UniversityInfoDTO getUniversityInfoBYId(Long universityId);

	UniversityInfoDTO updateUniversityInfo(Long universityId, UniversityInfoDTO universityInfo);
	
	String deleteUniversityInfo(Long universityId);
}
