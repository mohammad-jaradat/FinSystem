package com.qu.finsys.generalLedger.repositories;

import com.qu.finsys.generalLedger.entities.GlCurrency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GlCurrencyRepository extends JpaRepository<GlCurrency,Long> {
}
