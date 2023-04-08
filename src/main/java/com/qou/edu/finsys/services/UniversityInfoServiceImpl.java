package com.qou.edu.finsys.services;

import com.qou.edu.finsys.config.AppConstants;
import com.qou.edu.finsys.entities.Role;
import com.qou.edu.finsys.entities.UniversityInfo;
import com.qou.edu.finsys.entities.User;
import com.qou.edu.finsys.exceptions.APIException;
import com.qou.edu.finsys.exceptions.ResourceNotFoundException;
import com.qou.edu.finsys.payloads.EntityResponse;
import com.qou.edu.finsys.payloads.UniversityInfoDTO;
import com.qou.edu.finsys.payloads.UserDTO;
import com.qou.edu.finsys.payloads.UserResponse;
import com.qou.edu.finsys.repositories.RoleRepository;
import com.qou.edu.finsys.repositories.UniversityInfoRepository;
import com.qou.edu.finsys.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@Service
@RequiredArgsConstructor
public class UniversityInfoServiceImpl implements UniversityInfoService {

	/****************************************************************/

	private final UniversityInfoRepository universityInfoRepository;
	private final RoleRepository roleRepository;
	private final PasswordEncoder passwordEncoder;
	private final ModelMapper modelMapper;
	@Override
	public UniversityInfoDTO getUniversityInfo(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder) {
		return null;
	}

	@Override
	public UniversityInfoDTO getUniversityInfoBYId(Long universityId) {
		UniversityInfo universityInfo = universityInfoRepository.findById(universityId)
				.orElseThrow(() -> new ResourceNotFoundException("UniversityInfo", "universityId", universityId));

		UniversityInfoDTO universityInfoDTO = modelMapper.map(universityId, UniversityInfoDTO.class);
		return universityInfoDTO;
	}

	@Override
	public UniversityInfoDTO updateUniversityInfo(Long universityId, UniversityInfoDTO universityInfo) {
		return null;
	}

	@Override
	public String deleteUniversityInfo(Long universityId) {
		return null;
	}
}
