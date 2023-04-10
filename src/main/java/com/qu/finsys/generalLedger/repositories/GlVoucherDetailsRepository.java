package com.qu.finsys.generalLedger.repositories;

import com.qu.finsys.generalLedger.entities.GlVoucherDetails;
import com.qu.finsys.generalLedger.entities.GlVoucherDetailsPk;
import org.springframework.data.jpa.repository.JpaRepository;

/*
  Created by IntelliJ IDEA.
  User: Ibrahim Assi (iassi)
  Date: 10/04/2023
  Time: 10:37 PM
*/
public interface GlVoucherDetailsRepository  extends JpaRepository<GlVoucherDetails, GlVoucherDetailsPk> {
}
