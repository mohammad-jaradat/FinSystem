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
  Time: 2:58 PM
*/
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "gl_voucher_master")
public class GlVoucherMaster {

    @EmbeddedId
    private GlVoucherMasterPk voucherMasterPk;

    @Column(name = "voucher_date", nullable = false)
    private Date voucherDate;
    @Column(name = "currency_no", length = 20, nullable = false)
    private Long currencyNo;
    @Column(name = "voucher_status", length = 10, nullable = false)
    private String voucherStatus;
    @Column(name = "voucher_desc", length = 100, nullable = false)
    private String voucherDesc;
    @Column(name = "is_auto", nullable = false)
    private Boolean isAuto;
    @Column(name = "ref_no", length = 20, nullable = false)
    private String refNo;
    @Column(name = "cash_amount", length = 20, nullable = false)
    private Double cashAmount;
    @Column(name = "cheques_amount", length = 20, nullable = false)
    private Double chequesAmount;
    @Column(name = "transfer_amount", length = 20, nullable = false)
    private Double transferAmount;
    @Column(name = "is_printed",  nullable = false)
    private Boolean isPrinted;
    @Column(name = "print_counter", length = 10, nullable = false)
    private Integer printCounter;
    @Column(name = "reverse_to_voucher_type", length = 10, nullable = false)
    private String  reverseToVoucherType;
    @Column(name = "reverse_to_voucher_no", length = 20, nullable = false)
    private Long  reverseToVoucherNo;
    @Column(name = "voucher_created_by", length = 30, nullable = false)
    private String  voucherCreatedBy;


    @OneToMany(
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY
    )
    private List<GlVoucherDetails> voucherDetailsList = new ArrayList<>();
}
