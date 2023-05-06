package com.qu.finsys.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

/*
    @Column(name = "operation")
    private String operation;

    @Column(name = "timestamp")
    private long timestamp;


    @PrePersist
    public void onPrePersist() {   audit("INSERT"); }

    @PreUpdate
    public void onPreUpdate() {     audit("UPDATE"); }

    @PostPersist
    @PreRemove
    public void onPreRemove() {  audit("DELETE"); }


    private void audit(String operation) {
        setOperation(operation);
        setTimestamp((new Date()).getTime());
    }
    */
}
