package edu.qou.financial.gl.services;

import edu.qou.financial.exceptions.APIException;
import edu.qou.financial.exceptions.ResourceNotFoundException;
import edu.qou.financial.gl.dtos.UniversityCenterDTO;
import edu.qou.financial.gl.entities.UniversityCenter;
import edu.qou.financial.gl.payloads.UniversityCenterResponse;
import edu.qou.financial.gl.repositories.UniversityCenterRepository;
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
public class UniversityCenterServiceImpl implements UniversityCenterService {

    private final UniversityCenterRepository universityCenterRepository;
    private final ModelMapper modelMapper;

    @Override
    public UniversityCenterResponse getAllCentersInfo(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder) {
        Sort sortByAndOrder = sortOrder.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageDetails = PageRequest.of(pageNumber, pageSize, sortByAndOrder);

        Page<UniversityCenter> universityCenterPage = universityCenterRepository.findAll(pageDetails);

        List<UniversityCenter> universityCentersList = universityCenterPage.getContent();

        if (universityCentersList.size() == 0) {
            throw new APIException("No Centers exists !!!");
        }

        List<UniversityCenterDTO> universityCenterDTOS = universityCentersList.stream().map(universityCenter ->

                modelMapper.map(universityCenter, UniversityCenterDTO.class)).toList();

        UniversityCenterResponse universityCenterResponse = new UniversityCenterResponse();

        universityCenterResponse.setContent(universityCenterDTOS);
        universityCenterResponse.setPageNumber(universityCenterPage.getNumber());
        universityCenterResponse.setPageSize(universityCenterPage.getSize());
        universityCenterResponse.setTotalElements(universityCenterPage.getTotalElements());
        universityCenterResponse.setTotalPages(universityCenterPage.getTotalPages());
        universityCenterResponse.setLastPage(universityCenterPage.isLast());

        return universityCenterResponse;
    }

    @Override
    public UniversityCenterDTO getCenterBYId(Long centerId) {
        return null;
    }

    @Override
    public UniversityCenterDTO updateCenter(Long centerId, UniversityCenterDTO universityCenterDTO) {
        UniversityCenter universityCenter = universityCenterRepository.findById(centerId)
                .orElseThrow(() -> new ResourceNotFoundException("universityCenter", "centerId", centerId));
        return modelMapper.map(universityCenter, UniversityCenterDTO.class);
    }

    @Override
    public String deleteCenter(Long centerId) {
        UniversityCenter universityCenter = universityCenterRepository.findById(centerId)
                .orElseThrow(() -> new ResourceNotFoundException("universityCenter", "centerId", centerId));
        universityCenterRepository.delete(universityCenter);
        return "UniversityCenter with centerId " + centerId + " deleted successfully!!!";
    }

}
