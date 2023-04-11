package com.qou.edu.finsys.gl.controllers;

import com.qou.edu.finsys.config.AppConstants;
import com.qou.edu.finsys.gl.dtos.UniversityCenterDTO;
import com.qou.edu.finsys.gl.dtos.UniversityInfoDTO;
import com.qou.edu.finsys.gl.payloads.UniversityCenterResponse;
import com.qou.edu.finsys.gl.payloads.UniversityInfoResponse;
import com.qou.edu.finsys.gl.services.UniversityCenterService;
import com.qou.edu.finsys.gl.services.UniversityInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "${cross.address}")
@RequiredArgsConstructor
public class UniversityCenterController {

    private final UniversityCenterService universityCenterService;

    @GetMapping("/admin/universityCenters")
    public ResponseEntity<UniversityCenterResponse> getAllUniversityCentersInfo(
            @RequestParam(name = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
            @RequestParam(name = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
            @RequestParam(name = "sortBy", defaultValue = AppConstants.SORT_USERS_BY, required = false) String sortBy,
            @RequestParam(name = "sortOrder", defaultValue = AppConstants.SORT_DIR, required = false) String sortOrder) {

        UniversityCenterResponse universityCenterResponse = universityCenterService.getAllCentersInfo(pageNumber, pageSize, sortBy, sortOrder);

        return ResponseEntity.ok(universityCenterResponse);
    }

    @GetMapping("/admin/universityCenters/{centerId}")
    public ResponseEntity<UniversityCenterDTO> getUniversityCenter(@PathVariable Long centerId) {
        UniversityCenterDTO universityCenterDTO = universityCenterService.getCenterBYId(centerId);

        return ResponseEntity.ok(universityCenterDTO);
    }

    @PutMapping("/admin/universityCenters/{centerId}")
    public ResponseEntity<UniversityCenterDTO> updateUniversityCenter(@RequestBody UniversityCenterDTO universityCenterDTO, @PathVariable Long centerId) {
        UniversityCenterDTO updatedUniversityCenterDTO = universityCenterService.updateCenter(centerId, universityCenterDTO);

        return ResponseEntity.ok(updatedUniversityCenterDTO);
    }

    @DeleteMapping("/admin/universityCenters/{centerId}")
    //@PreAuthorize("universityCenters_deleteCenter")
    public ResponseEntity<String> deleteCenter(@PathVariable Long centerId) {
        String status = universityCenterService.deleteCenter(centerId);

        return ResponseEntity.ok(status);
    }
}
