package com.qu.finsys.generalLedger.services;

import com.qu.finsys.generalLedger.repositories.GlVoucherChequesPictureRepository;
import com.qu.finsys.generalLedger.repositories.GlVoucherChequesRepository;
import com.qu.finsys.generalLedger.repositories.GlVoucherDetailsRepository;
import com.qu.finsys.generalLedger.repositories.GlVoucherMasterRepository;
import lombok.RequiredArgsConstructor;

/*
  Created by IntelliJ IDEA.
  User: Ibrahim Assi (iassi)
  Date: 10/04/2023
  Time: 10:46 PM
*/

@RequiredArgsConstructor
public class VoucherServiceImpl implements VoucherService{

    private final GlVoucherMasterRepository voucherMasterRepository;
    private final GlVoucherDetailsRepository voucherDetailsRepository;
    private final GlVoucherChequesRepository voucherChequesRepository;
    private final GlVoucherChequesPictureRepository voucherChequesPictureRepository;


}
