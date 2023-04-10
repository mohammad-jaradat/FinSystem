package com.qu.finsys.generalLedger.repositories;

import com.qu.finsys.generalLedger.entities.GlVoucherMaster;
import com.qu.finsys.generalLedger.entities.GlVoucherMasterPk;
import org.springframework.data.jpa.repository.JpaRepository;

/*
  Created by IntelliJ IDEA.
  User: Ibrahim Assi (iassi)
  Date: 10/04/2023
  Time: 10:36 PM
*/
public interface GlVoucherMasterRepository extends JpaRepository<GlVoucherMaster, GlVoucherMasterPk> {
}
