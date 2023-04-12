package com.qu.finsys.generalLedger.entities.dto;

import com.qu.finsys.generalLedger.entities.GlVoucherCheques;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
  Created by IntelliJ IDEA.
  User: Ibrahim Assi (iassi)
  Date: 11/04/2023
  Time: 1:21 PM
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VoucherDetailsDTO {

    private Integer rowNo;
    private String  accountNo;
    private Double  currencyRate;
    private String  rowDesc;
    private Double  debitTransAmount;
    private Double  debitBaseTransAmount;
    private Double  creditTransAmount;
    private Double  creditBaseTransAmount;
    private Long    transferNo;
    private Date    transferDate;


    private List<VoucherChequesDTO> voucherChequesList = new ArrayList<>();
}
