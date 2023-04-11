package com.qou.edu.finsys.gl.services;

import com.qou.edu.finsys.exceptions.APIException;
import com.qou.edu.finsys.exceptions.ResourceNotFoundException;
import com.qou.edu.finsys.gl.dtos.UniversityInfoDTO;
import com.qou.edu.finsys.gl.entities.UniversityInfo;
import com.qou.edu.finsys.gl.payloads.UniversityInfoResponse;
import com.qou.edu.finsys.gl.repositories.UniversityInfoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class UniversityInfoServiceImpl implements UniversityInfoService {

    private final UniversityInfoRepository universityInfoRepository;
    private final ModelMapper modelMapper;

    @Override
    public UniversityInfoResponse getAllUniversitiesInfo(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder) {
        Sort sortByAndOrder = sortOrder.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageDetails = PageRequest.of(pageNumber, pageSize, sortByAndOrder);

        Page<UniversityInfo> universityInfoPage = universityInfoRepository.findAll(pageDetails);

        List<UniversityInfo> universityInfoList = universityInfoPage.getContent();

        if (universityInfoList.size() == 0) {
            throw new APIException("No University exists !!!");
        }

        List<UniversityInfoDTO> universityInfoDTOS = universityInfoList.stream().map(universityInfo ->
                        modelMapper.map(universityInfo, UniversityInfoDTO.class)).toList();

        UniversityInfoResponse universityInfoResponse = new UniversityInfoResponse();

        universityInfoResponse.setContent(universityInfoDTOS);
        universityInfoResponse.setPageNumber(universityInfoPage.getNumber());
        universityInfoResponse.setPageSize(universityInfoPage.getSize());
        universityInfoResponse.setTotalElements(universityInfoPage.getTotalElements());
        universityInfoResponse.setTotalPages(universityInfoPage.getTotalPages());
        universityInfoResponse.setLastPage(universityInfoPage.isLast());

        return universityInfoResponse;
    }

    @Override
    public UniversityInfoDTO getUniversityInfoBYId(Long universityId) {
        UniversityInfo universityInfo = universityInfoRepository.findById(universityId)
                .orElseThrow(() -> new ResourceNotFoundException("UniversityInfo", "universityId", universityId));

        return modelMapper.map(universityId, UniversityInfoDTO.class);
    }

    @Override
    public UniversityInfoDTO updateUniversityInfo(Long universityId, UniversityInfoDTO universityInfoDTO) {
        UniversityInfo universityInfo = universityInfoRepository.findById(universityId)
                .orElseThrow(() -> new ResourceNotFoundException("UniversityInfo", "universityId", universityId));

        universityInfo.setUnivAName(universityInfoDTO.univAName());
        universityInfo.setUnivTel1(universityInfoDTO.univTel1());
        universityInfo.setUnivTel2(universityInfoDTO.univTel2());
        universityInfo.setUnivFax1(universityInfoDTO.univFax1());
        universityInfo.setUnivFax2(universityInfoDTO.univFax2());
        universityInfo.setUnivWebsite(universityInfoDTO.univWebsite());
        universityInfo.setUnivEmail(universityInfoDTO.univEmail());
        universityInfo.setUnivPresName(universityInfoDTO.univPresName());
        universityInfo.setUnivLogo(universityInfoDTO.univLogo());

        return modelMapper.map(universityInfo, UniversityInfoDTO.class);
    }

    @Override
    public String deleteUniversityInfo(Long universityId) {
        UniversityInfo universityInfo = universityInfoRepository.findById(universityId)
                .orElseThrow(() -> new ResourceNotFoundException("UniversityInfo", "universityId", universityId));
        universityInfoRepository.delete(universityInfo);
        return "UniversityInfo with universityId " + universityId + " deleted successfully!!!";
    }
}
