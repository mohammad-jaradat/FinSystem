package com.qou.edu.finsys.gl.payloads;

import com.qou.edu.finsys.gl.dtos.UniversityCenterDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UniversityCenterResponse {
	
	private List<UniversityCenterDTO> content;
	private Integer pageNumber;
	private Integer pageSize;
	private Long totalElements;
	private Integer totalPages;
	private boolean lastPage;
	
}
