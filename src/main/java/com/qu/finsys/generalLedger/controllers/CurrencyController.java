package com.qu.finsys.generalLedger.controllers;

import com.qu.finsys.generalLedger.entities.GlCurrency;
import com.qu.finsys.generalLedger.services.CurrencyServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/currency")
@CrossOrigin("http://localhost:4200")
public class CurrencyController {
    
    private final CurrencyServiceImpl currencyService;

    @GetMapping("/currencies")
    public List<GlCurrency> currencyInfo() {
        List<GlCurrency> currList = currencyService.getAllCurrencies();
        return currList;
    }
 
    @GetMapping("/rates/{fromCurrencyId}/{toCurrencyId}")
    public Double getMaxSaleRateCurrency(@PathVariable Long fromCurrencyId, @PathVariable Long toCurrencyId) {
       // return currencyService.getMaxSaleRateCurrency(fromCurrencyId,toCurrencyId);
        return null;
    }
}
