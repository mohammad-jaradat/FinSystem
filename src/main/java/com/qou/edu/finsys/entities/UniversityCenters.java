package com.qou.edu.finsys.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(name = "university_centers")
public class UniversityCenters {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long centerNo;

    private String centerAName;
    private String centerEName;
    @Size(min = 10, max = 10, message = "Tel Number must be exactly 10 digits long")
    @Pattern(regexp = "^\\d{10}$", message = "Tel Number must contain only Numbers")
    private String centerTel1;
    @Size(min = 10, max = 10, message = "Tel Number must be exactly 10 digits long")
    @Pattern(regexp = "^\\d{10}$", message = "Tel Number must contain only Numbers")
    private String centerTel2;
    @Size(min = 10, max = 13, message = "Fax Number must be 10-13 digits long")
    @Pattern(regexp = "^\\d{13}$", message = "Fax Number must contain only Numbers")
    private String centerFax1;
    @Size(min = 10, max = 13, message = "Fax Number must be 10-13 digits long")
    @Pattern(regexp = "^\\d{13}$", message = "Fax Number must contain only Numbers")
    private String centerFax2;
    private String centerAddress;
    @Email
    private String centerEmail;
    @Column(nullable = false,columnDefinition = "NUMBER(1) DEFAULT 1")
    private Boolean isActive;
    @Column(nullable = false)
    private String createdBy;
    @Column(nullable = false,columnDefinition = "DATE DEFAULT SYSDATE")
    private Date createdDate;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
    @JoinTable(name = "university_center_map", joinColumns = @JoinColumn(name = "univ_id"), inverseJoinColumns = @JoinColumn(name = "center_id"))
    private Set<UniversityInfo> universityCenters = new HashSet<>();
}
