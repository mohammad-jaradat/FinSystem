package com.qu.finsys.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class GlVoucherNumbersPK implements Serializable {
    @Column(name = "type_Code")
    private String typeCode;

    @Column(name = "intrvl_no")
    private String intrvlNo;
}
