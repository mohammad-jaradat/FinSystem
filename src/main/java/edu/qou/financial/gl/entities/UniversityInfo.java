package edu.qou.financial.gl.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(name = "university_info")
public class UniversityInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long univId;

    private String univAName;
    private String univEName;
    @Size(min = 10, max = 10, message = "Tel Number must be exactly 10 digits long")
    @Pattern(regexp = "^\\d{10}$", message = "Tel Number must contain only Numbers")
    private String univTel1;
    @Size(min = 10, max = 10, message = "Tel Number must be exactly 10 digits long")
    @Pattern(regexp = "^\\d{10}$", message = "Tel Number must contain only Numbers")
    private String univTel2;
    @Size(min = 10, max = 13, message = "Fax Number must be 10-13 digits long")
    @Pattern(regexp = "^\\d{13}$", message = "Fax Number must contain only Numbers")
    private String univFax1;
    @Size(min = 10, max = 13, message = "Fax Number must be 10-13 digits long")
    @Pattern(regexp = "^\\d{13}$", message = "Fax Number must contain only Numbers")
    private String univFax2;
    private String univWebsite;
    @Email
    private String univEmail;
    private String univPresName;
    private String univLogo;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(name = "university_center_map", joinColumns = @JoinColumn(name = "univ_id"), inverseJoinColumns = @JoinColumn(name = "center_id"))
    private Set<UniversityCenter> universityCenters = new HashSet<>();
}
