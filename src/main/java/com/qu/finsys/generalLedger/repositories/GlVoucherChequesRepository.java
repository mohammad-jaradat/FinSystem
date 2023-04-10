package com.qu.finsys.generalLedger.repositories;

import com.qu.finsys.generalLedger.entities.GlVoucherCheques;
import com.qu.finsys.generalLedger.entities.GlVoucherChequesPk;
import org.springframework.data.jpa.repository.JpaRepository;

/*
  Created by IntelliJ IDEA.
  User: Ibrahim Assi (iassi)
  Date: 10/04/2023
  Time: 10:39 PM
*/
public interface GlVoucherChequesRepository  extends JpaRepository<GlVoucherCheques, GlVoucherChequesPk> {
}
