package com.qu.finsys.generalLedger.entities.dto;

import com.qu.finsys.generalLedger.entities.GlVoucherChequesPicture;
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
  Time: 1:24 PM
*/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VoucherChequesDTO {

    private Long    chequeNo;
    private Long    chequeAccountNo;
    private Integer chequeTransSeq;
    private Double  chequeAmount;
    private Date    chequeDate;
    private Long    chequeBankBranchNo;
    private Boolean isPersonal;
    private String  chequeStatus;
    private Long    chequeTransAccountNo;
    private String  notes;

    private List<byte[]> chequePictureList = new ArrayList<>();
}
