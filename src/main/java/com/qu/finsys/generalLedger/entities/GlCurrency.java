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
    @Column(name = "currency_id", length = 2, nullable = false)
    private Long currencyId;
    @Column(name = "currency_ar_name", length = 25, nullable = false)
    private String currencyArName;
    @Column(name = "currency_en_name", length = 25, nullable = false)
    private String currencyEnName;
    @Column(name = "currency_code", length = 5, nullable = false)
    private String currencyCode;
    @Column(name = "currency_part_ar_name", length = 25, nullable = false)
    private String currencyPartArName;
    @Column(name = "currency_part_en_name", length = 25, nullable = false)
    private String currencyPartEnName;
    @Column(name = "is_main_currency", nullable = false)
    private Boolean isMaincurrency;
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
    @JoinColumn(name = "from_currency_id", referencedColumnName = "currency_id")
    private List<GlCurrencyRates> currencyRatesList = new ArrayList<>();

    public GlCurrency(String currencyArName, String currencyEnName,
                      String currencyCode, String currencyPartArName, String currencyPartEnName, Boolean isMaincurrency,
                      Double minRate, Double maxRate, Boolean isActive ) {
        this.currencyArName = currencyArName;
        this.currencyEnName = currencyEnName;
        this.currencyCode = currencyCode;
        this.currencyPartArName = currencyPartArName;
        this.currencyPartEnName = currencyPartEnName;
        this.isMaincurrency = isMaincurrency;
        this.minRate = minRate;
        this.maxRate = maxRate;
        this.isActive = isActive;
    }

 
}
