package com.qu.finsys.generalLedger.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/*
  Created by IntelliJ IDEA.
  User: Ibrahim Assi (iassi)
  Date: 10/04/2023
  Time: 2:58 PM
*/

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class GlVoucherMasterPk  implements Serializable {

    @Column(name = "interval_no", length = 20, nullable = false)
    private Long intervalNo;
    @Column(name = "center_no", length = 5, nullable = false)
    private String centerNo;
    @Column(name = "voucher_type", length = 10, nullable = false)
    private String voucherType;
    @Column(name = "voucher_no", length = 20, nullable = false)
    private Long voucherNo;

}
