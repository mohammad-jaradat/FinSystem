package com.qu.finsys.generalLedger.repositories;

import com.qu.finsys.generalLedger.entities.GlVoucherChequesPicture;
import com.qu.finsys.generalLedger.entities.GlVoucherChequesPicturePk;
import org.springframework.data.jpa.repository.JpaRepository;

/*
  Created by IntelliJ IDEA.
  User: Ibrahim Assi (iassi)
  Date: 10/04/2023
  Time: 10:40 PM
*/
public interface GlVoucherChequesPictureRepository  extends JpaRepository<GlVoucherChequesPicture, GlVoucherChequesPicturePk> {
}
