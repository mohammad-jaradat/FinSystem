package com.qou.edu.finsys.gl.dtos;

import com.qou.edu.finsys.gl.entities.UniversityCenter;

import java.util.Set;

public record UniversityInfoDTO(Long univId, String univAName, String univEName, String univTel1, String univTel2,
                                String univFax1, String univFax2, String univWebsite, String univEmail,
                                String univPresName, String univLogo, Set<UniversityCenter> centers) {
}

