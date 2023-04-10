package com.qu.finsys.generalLedger.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter 
@NoArgsConstructor
@AllArgsConstructor 
@Embeddable
public class GlCurrencyRatesPk implements Serializable {

    @Column(name = "from_currency_id", length = 50, nullable = false)
    private Long fromCurrencyId;
    @Column(name ="to_currency_id",  length = 50, nullable = false)
    private Long toCurrencyId;
    @Column(name = "rate_date", length = 50, nullable = false)
    private Date rateDate;

}
 
