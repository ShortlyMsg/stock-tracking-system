package com.trackingsys.stocktrackingsystem.dto;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CustomerDto {
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String identityNumber;
}
