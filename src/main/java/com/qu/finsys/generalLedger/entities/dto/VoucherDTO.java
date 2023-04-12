package com.qu.finsys.generalLedger.entities.dto;

import com.qu.finsys.generalLedger.entities.GlVoucherDetails;
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
  Time: 1:18 PM
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VoucherDTO {

    private Long    intervalNo;
    private String  centerNo;
    private String  voucherType;
    private Long    voucherNo;
    private Date    voucherDate;
    private Long    currencyNo;
    private String  voucherStatus;
    private String  voucherDesc;
    private Boolean isAuto;
    private String  refNo;
    private Double  cashAmount;
    private Double  chequesAmount;
    private Double  transferAmount;
    private Boolean isPrinted;
    private Integer printCounter;
    private String  reverseToVoucherType;
    private Long    reverseToVoucherNo;
    private String  voucherCreatedBy;


    private List<VoucherDetailsDTO> voucherDetailsList = new ArrayList<>();
}
