package com.trackingsys.stocktrackingsystem.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CompanyDto {

    private String companyName;
    private String webAddress;
    private String taxNumber;
    private String companyPhoneNumber;
}
