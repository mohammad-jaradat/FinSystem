package com.qou.edu.finsys.gl.controllers;

import com.qou.edu.finsys.config.AppConstants;
import com.qou.edu.finsys.gl.dtos.UniversityInfoDTO;
import com.qou.edu.finsys.gl.payloads.UniversityInfoResponse;
import com.qou.edu.finsys.gl.services.UniversityInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "${cross.address}")
@RequiredArgsConstructor
public class UniversityInfoController {

	private final UniversityInfoService universityInfoService;
	
	@GetMapping("/admin/universities")
	public ResponseEntity<UniversityInfoResponse> getAllUniversitiesInfo(
			@RequestParam(name = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
			@RequestParam(name = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
			@RequestParam(name = "sortBy", defaultValue = AppConstants.SORT_USERS_BY, required = false) String sortBy,
			@RequestParam(name = "sortOrder", defaultValue = AppConstants.SORT_DIR, required = false) String sortOrder) {

		UniversityInfoResponse universityInfoResponse = universityInfoService.getAllUniversitiesInfo(pageNumber, pageSize, sortBy, sortOrder);
		
		return ResponseEntity.ok(universityInfoResponse);
	}
	
	@GetMapping("/admin/universities/{universityId}")
	public ResponseEntity<UniversityInfoDTO> getUniversityInfo(@PathVariable Long universityId) {
		UniversityInfoDTO universityInfoDTO = universityInfoService.getUniversityInfoBYId(universityId);
		
		return ResponseEntity.ok(universityInfoDTO);
	}
	
	@PutMapping("/admin/universities/{universityId}")
	public ResponseEntity<UniversityInfoDTO> updateUniversityInfo(@RequestBody UniversityInfoDTO universityInfoDTO, @PathVariable Long universityId) {
		UniversityInfoDTO  updatedUniversityInfoDTO = universityInfoService.updateUniversityInfo(universityId, universityInfoDTO);
		
		return ResponseEntity.ok(updatedUniversityInfoDTO);
	}
	
	@DeleteMapping("/admin/universities/{universityId}")
	//@PreAuthorize("users_deleteuser")
	public ResponseEntity<String> deleteUniversityInfo(@PathVariable Long universityId) {
		String status = universityInfoService.deleteUniversityInfo(universityId);
		
		return ResponseEntity.ok(status);
	}
}
