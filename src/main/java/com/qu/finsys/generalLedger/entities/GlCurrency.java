package com.qu.finsys.generalLedger.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "gl_currencies") 
public class GlCurrency {
  
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "curr_id", length = 2, nullable = false)
    private Long currId;
    @Column(name = "curr_ar_name", length = 25, nullable = false)
    private String currArName;
    @Column(name = "curr_en_name", length = 25, nullable = false)
    private String currEnName; 
    @Column(name = "curr_code", length = 5, nullable = false)
    private String currCode;
    @Column(name = "curr_part_ar_name", length = 25, nullable = false)
    private String currPartArName;
    @Column(name = "curr_part_en_name", length = 25, nullable = false)
    private String currPartEnName;
    @Column(name = "is_main_curr", nullable = false)
    private Boolean isMainCurr;
    @Column(name = "min_rate", length = 50, nullable = false)
    private Double minRate;
    @Column(name = "max_rate", length = 8, nullable = false)
    private Double maxRate;
    @Column(name = "is_active", length = 8, nullable = false)
    private Boolean isActive;

    @OneToMany(
        cascade = CascadeType.PERSIST,
        fetch = FetchType.LAZY
    )     
    private List<GlCurrencyRates> currencyRatesList = new ArrayList<>();

    public GlCurrency(String currArName, String currEnName,  
                      String currCode, String currPartArName, String currPartEnName, Boolean isMainCurr,
                      Double minRate, Double maxRate, Boolean isActive ) {
        this.currArName = currArName;
        this.currEnName = currEnName; 
        this.currCode = currCode;
        this.currPartArName = currPartArName;
        this.currPartEnName = currPartEnName;
        this.isMainCurr = isMainCurr;
        this.minRate = minRate;
        this.maxRate = maxRate;
        this.isActive = isActive;
    }

 
}
