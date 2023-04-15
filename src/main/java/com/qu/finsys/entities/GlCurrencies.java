package com.qu.finsys.entities;


import jakarta.persistence.*;
import lombok.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "Gl_Currencies")
public class GlCurrencies {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "curr_no", length = 4, nullable = false)
    private Long currNo;
    @Column(name = "curr_a_name", length = 20, nullable = false)
    private String currAName;
    @Column(name = "curr_e_name", length = 20, nullable = false)
    private String currEName;
    @Column(name = "curr_sign", length = 4, nullable = false)
    private String currSign;
    @Column(name = "curr_part_e_name", length = 10, nullable = false)
    private String currPartEname;
    @Column(name = "curr_part_a_name", length = 10, nullable = false)
    private String currPartAName;
    @Column(name = "min_rate", length = 50, nullable = false)
    private Double minRate;
    @Column(name = "max_rate", length = 8, nullable = false)
    private Double maxRate;
    @Column(name = "is_main_curr", nullable = false)
    private Boolean isMainCurr;
}
