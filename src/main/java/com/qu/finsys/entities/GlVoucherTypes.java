package com.qu.finsys.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GlVoucherTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  typeCode;
    private String typeAName;
    private String typeEName;

    @OneToMany(mappedBy="glVoucherTypes",fetch = FetchType.LAZY)
    private List<GlVoucherNumbers> glVoucherNumbers;

}
