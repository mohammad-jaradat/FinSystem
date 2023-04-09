package com.qou.edu.finsys.services;


import com.qou.edu.finsys.payloads.EntityResponse;
import com.qou.edu.finsys.payloads.UniversityInfoDTO;

public interface UniversityInfoService {
	UniversityInfoDTO getUniversityInfo(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

	UniversityInfoDTO getUniversityInfoBYId(Long universityId);

	UniversityInfoDTO updateUniversityInfo(Long universityId, UniversityInfoDTO universityInfo);
	
	String deleteUniversityInfo(Long universityId);
}
