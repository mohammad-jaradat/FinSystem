package com.qu.finsys.generalLedger.services;


import com.qu.finsys.generalLedger.entities.GlCurrency;

import java.util.List;

/*
  Created by IntelliJ IDEA.
  User: Ibrahim Assi (iassi)
  Date: 25/03/2023
  Time: 11:49 AM
*/
public interface CurrencyService {
    public List<GlCurrency> getAllCurrencies();
}
