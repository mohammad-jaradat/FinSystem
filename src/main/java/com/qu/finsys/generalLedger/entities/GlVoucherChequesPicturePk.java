package com.qu.finsys.generalLedger.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/*
  Created by IntelliJ IDEA.
  User: Ibrahim Assi (iassi)
  Date: 10/04/2023
  Time: 8:00 PM
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class GlVoucherChequesPicturePk implements Serializable {

    @Column(name = "interval_no", length = 20, nullable = false)
    private Long intervalNo;
    @Column(name = "center_no", length = 5, nullable = false)
    private String centerNo;
    @Column(name = "voucher_type", length = 10, nullable = false)
    private String voucherType;
    @Column(name = "voucher_no", length = 20, nullable = false)
    private Long voucherNo;
    @Column(name = "row_no", length = 10, nullable = false)
    private Integer rowNo;
    @Column(name = "cheque_no", length = 20, nullable = false)
    private Long chequeNo;
    @Column(name = "cheque_account_no", length = 20, nullable = false)
    private Long chequeAccountNo;
    @Column(name = "cheque_trans_seq", length = 10, nullable = false)
    private Integer chequeTransSeq;


}
