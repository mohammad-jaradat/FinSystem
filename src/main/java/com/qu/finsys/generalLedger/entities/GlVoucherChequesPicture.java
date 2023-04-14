package com.qu.finsys.generalLedger.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
  Created by IntelliJ IDEA.
  User: Ibrahim Assi (iassi)
  Date: 10/04/2023
  Time: 8:36 PM
*/
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "gl_voucher_cheques_picture")
public class GlVoucherChequesPicture {

    @EmbeddedId
    private GlVoucherChequesPicturePk voucherChequesPicturePk;
    private byte[] chequePicture;
}
