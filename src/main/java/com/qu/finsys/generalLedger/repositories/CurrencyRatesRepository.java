package com.qu.finsys.generalLedger.repositories;

import com.qu.finsys.generalLedger.entities.GlCurrency;
import com.qu.finsys.generalLedger.entities.GlCurrencyRates;
import com.qu.finsys.generalLedger.entities.GlCurrencyRatesPk;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CurrencyRatesRepository extends JpaRepository<GlCurrencyRates, GlCurrencyRatesPk> {
     

    //List<GlCurrencyRates> findMaxByFromCurrencyAndToCurrency(GlCurrency fromCurrency, GlCurrency toCurrency);
}
