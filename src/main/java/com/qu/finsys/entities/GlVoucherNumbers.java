package com.qu.finsys.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GlVoucherNumbers {
    @EmbeddedId
    private GlVoucherNumbersPK glVoucherNumbersPK;
    private Long firstVoucherNo;
    private Date firstVoucherDate;
    private Long lastVoucherNo;
    private Date lastVoucherDate;


    @ManyToOne
    @MapsId("typeCode")
    private GlVoucherTypes glVoucherTypes;
}
