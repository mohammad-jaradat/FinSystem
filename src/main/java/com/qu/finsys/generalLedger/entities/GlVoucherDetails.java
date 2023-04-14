package com.qu.finsys.generalLedger.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
  Created by IntelliJ IDEA.
  User: Ibrahim Assi (iassi)
  Date: 10/04/2023
  Time: 7:37 PM
*/
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "gl_voucher_details")
public class GlVoucherDetails {
    @EmbeddedId
    private GlVoucherDetailsPk voucherDetailsPk;

    @Column(name = "account_no",length = 20,nullable = false)
    private String accountNo;
    @Column(name = "currency_rate",length = 20,nullable = false)
    private Double currencyRate;
    @Column(name = "row_desc",length = 100,nullable = false)
    private String rowDesc;
    @Column(name = "debit_trans_amount",length = 20,nullable = false)
    private Double debitTransAmount;
    @Column(name = "debit_base_trans_amount",length = 20,nullable = false)
    private Double debitBaseTransAmount;
    @Column(name = "credit_trans_amount",length = 20,nullable = false)
    private Double creditTransAmount;
    @Column(name = "credit_base_amount",length = 20,nullable = false)
    private Double creditBaseTransAmount;
    @Column(name = "transfer_no",length = 20,nullable = false)
    private Long   transferNo;
    @Column(name = "transfer_date",nullable = false)
    private Date   transferDate;


    @OneToMany(
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY
    )
    @JoinColumns({
            @JoinColumn(name = "interval_no",  referencedColumnName = "interval_no"),
            @JoinColumn(name = "center_no",    referencedColumnName = "center_no"),
            @JoinColumn(name = "voucher_type", referencedColumnName = "voucher_type"),
            @JoinColumn(name = "voucher_no",   referencedColumnName = "voucher_no"),
            @JoinColumn(name = "row_no",       referencedColumnName = "row_no")
    })
    private List<GlVoucherCheques> voucherChequesList = new ArrayList<>();

}
