package com.trackingsys.stocktrackingsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Getter
@Setter
@Entity
public class Company extends User{

    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "company_id")
    private String companyId;

    @NotNull
    @Column(name = "company_name")
    private String companyName;

    @NotNull
    @Column(name = "web_address")
    private String webAddress;

    @NotNull
    @Column(name = "tax_number")
    private String taxNumber;

    @NotNull
    @Column(name = "company_phone_number")
    private String companyPhoneNumber;
}
