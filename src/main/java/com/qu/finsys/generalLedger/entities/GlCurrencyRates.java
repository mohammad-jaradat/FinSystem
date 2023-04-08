package com.qu.finsys.generalLedger.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter 
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "gl_currencies_rates")
public class GlCurrencyRates {

    @EmbeddedId
    GlCurrencyRatesPk ratesPk;
    
    @Column(name = "sale_rate", length = 50, nullable = false)
    private Double  saleRate;
    @Column(name = "purchase_rate", length = 50, nullable = false)
    private Double  purchaseRate;
    @Column(name = "avg_rate", length = 50, nullable = false)
    private Double  avgRate;


}
