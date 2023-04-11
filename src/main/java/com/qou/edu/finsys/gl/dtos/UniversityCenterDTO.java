package com.qou.edu.finsys.gl.dtos;

import java.util.Date;

public record UniversityCenterDTO(Long centerNo, String centerAName, String centerEName, String centerTel1,
                                  String centerTel2, String centerFax1, String centerFax2, String centerAddress,
                                  String centerEmail, Boolean isActive, String createdBy, Date createdDate) {
}


