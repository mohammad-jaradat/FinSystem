package com.qu.finsys.generalLedger.entities;

/*
  Created by IntelliJ IDEA.
  User: Ibrahim Assi (iassi)
  Date: 10/04/2023
  Time: 8:23 PM
*/

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "gl_voucher_cheques")
public class GlVoucherCheques {

    @EmbeddedId
    private GlVoucherChequesPk voucherChequesPk;
    @Column(name = "cheque_amount",length = 20,nullable = false)
    private Double chequeAmount;
    @Column(name = "cheque_date",nullable = false)
    private Date chequeDate;
    @Column(name = "cheque_bank_branch_no",length = 20,nullable = false)
    private Long chequeBankBranchNo;
    @Column(name = "is_personal", nullable = false)
    private Boolean isPersonal;
    @Column(name = "cheque_status",length = 10,nullable = false)
    private String chequeStatus;
    @Column(name = "cheque_trans_account_no",length = 20,nullable = false)
    private Long chequeTransAccountNo;
    @Column(name = "notes",length = 100,nullable = false)
    private String notes;

}
