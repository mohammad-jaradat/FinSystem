package edu.qou.financial.gl.dtos;

import edu.qou.financial.gl.entities.UniversityCenter;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UniversityInfoDTO {
    private Long univId;
    private String univAName;
    private String univEName;
    private String univTel1;
    private String univTel2;
    private String univFax1;
    private String univFax2;
    private String univWebsite;
    private String univEmail;
    private String univPresName;
    private String univLogo;
    private Set<UniversityCenter> universityCenters;

}