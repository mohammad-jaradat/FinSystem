package edu.qou.financial.gl.services;

import edu.qou.financial.exceptions.APIException;
import edu.qou.financial.exceptions.ResourceNotFoundException;
import edu.qou.financial.gl.dtos.UniversityInfoDTO;
import edu.qou.financial.gl.entities.UniversityInfo;
import edu.qou.financial.gl.payloads.UniversityInfoResponse;
import edu.qou.financial.gl.repositories.UniversityInfoRepository;
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
    public UniversityInfoDTO addUniversityInfo(UniversityInfoDTO universityInfo) {
//        UniversityInfo universityInfo = universityInfoRepository.findById() // check duplicate, mapto entity , add entity , maptoDTO , return
        return null;
    }

    @Override
    public UniversityInfoDTO updateUniversityInfo(Long universityId, UniversityInfoDTO universityInfoDTO) {
        UniversityInfo universityInfo = universityInfoRepository.findById(universityId)
                .orElseThrow(() -> new ResourceNotFoundException("UniversityInfo", "universityId", universityId));

        universityInfo.setUnivAName(universityInfoDTO.getUnivAName());
        universityInfo.setUnivTel1(universityInfoDTO.getUnivTel1());
        universityInfo.setUnivTel2(universityInfoDTO.getUnivTel2());
        universityInfo.setUnivFax1(universityInfoDTO.getUnivFax1());
        universityInfo.setUnivFax2(universityInfoDTO.getUnivFax2());
        universityInfo.setUnivWebsite(universityInfoDTO.getUnivWebsite());
        universityInfo.setUnivEmail(universityInfoDTO.getUnivEmail());
        universityInfo.setUnivPresName(universityInfoDTO.getUnivPresName());
        universityInfo.setUnivLogo(universityInfoDTO.getUnivLogo());

        return modelMapper.map(universityInfo, UniversityInfoDTO.class);
    }

    @Override
    public Boolean deleteUniversityInfo(Long universityId) {
        UniversityInfo universityInfo = universityInfoRepository.findById(universityId)
                .orElseThrow(() -> new ResourceNotFoundException("UniversityInfo", "universityId", universityId));
        try {
            universityInfoRepository.delete(universityInfo);
        } catch (Exception ignored) {
            return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }
}
