package edu.qou.financial.gl.services;


import edu.qou.financial.gl.dtos.UniversityCenterDTO;
import edu.qou.financial.gl.payloads.UniversityCenterResponse;

public interface UniversityCenterService {
    UniversityCenterResponse getAllCentersInfo(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

    UniversityCenterDTO getCenterBYId(Long centerId);

    UniversityCenterDTO updateCenter(Long centerId, UniversityCenterDTO centersDTO);

    String deleteCenter(Long centerId);
}
