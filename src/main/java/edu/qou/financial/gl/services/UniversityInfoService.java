package edu.qou.financial.gl.services;


import edu.qou.financial.gl.dtos.UniversityInfoDTO;
import edu.qou.financial.gl.payloads.UniversityInfoResponse;

public interface UniversityInfoService {
    UniversityInfoResponse getAllUniversitiesInfo(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

    UniversityInfoDTO getUniversityInfoBYId(Long universityId);

    UniversityInfoDTO addUniversityInfo(UniversityInfoDTO universityInfo);

    UniversityInfoDTO updateUniversityInfo(Long universityId, UniversityInfoDTO universityInfo);

    Boolean deleteUniversityInfo(Long universityId);
}
