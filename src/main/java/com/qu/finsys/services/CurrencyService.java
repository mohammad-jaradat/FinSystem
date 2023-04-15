package com.qu.finsys.services;

import com.qu.finsys.payloads.CurrencyDTO;
import com.qu.finsys.payloads.CurrencyResponse;

public interface CurrencyService {
    CurrencyDTO addCurrency(CurrencyDTO currencyDTO);

    CurrencyResponse getAllCurrencies(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

    CurrencyDTO getCurrencyById(Long currNo);

    CurrencyDTO updateCurrency(Long currNo, CurrencyDTO currencyDTO);

    String deleteCurrency(Long currNo);
}
