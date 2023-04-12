package edu.qou.financial.gl.dtos;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UniversityCenterDTO {
    private Long centerNo;
    private String centerAName;
    private String centerEName;
    private String centerTel1;
    private String centerTel2;
    private String centerFax1;
    private String centerFax2;
    private String centerAddress;
    private String centerEmail;
    private Boolean isActive;
    private String createdBy;
    private Date createdDate;
}