package com.qu.finsys.generalLedger.services;

import com.qu.finsys.generalLedger.entities.GlCurrency;
import com.qu.finsys.generalLedger.entities.GlCurrencyRates;
import com.qu.finsys.generalLedger.repositories.CurrencyRatesRepository;
import com.qu.finsys.generalLedger.repositories.CurrencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl  implements CurrencyService{ 
    
    private final CurrencyRepository currencyRepository;
    private final CurrencyRatesRepository currencyRatesRepository;

    public List<GlCurrency> getAllCurrencies() {
        return currencyRepository.findAll();
    }

    public Double getMaxSaleRateCurrency(Long fromCurrencyId,Long toCurrencyId) {
        GlCurrency fromCurrency= currencyRepository.findById(fromCurrencyId).orElse(null);
        GlCurrency toCurrency= currencyRepository.findById(toCurrencyId).orElse(null);
        List<GlCurrencyRates> currencyRate = currencyRatesRepository.findMaxByFromCurrencyAndToCurrency(fromCurrency,toCurrency);
        return  currencyRate!=null && currencyRate.size()>0?currencyRate.get(0).getSaleRate():null;
    }
    
}
