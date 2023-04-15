package com.qu.finsys.repositories;

import com.qu.finsys.entities.GlCurrencies;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CurrencyRepository extends JpaRepository<GlCurrencies, Long> {
    Optional<GlCurrencies> findByCurrNo(Long currNo);

    @Override
    void delete(GlCurrencies currency);
}
