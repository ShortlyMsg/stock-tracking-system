package com.trackingsys.stocktrackingsystem.dto;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserDto {

    private String mail;
    private String password;
    private LocalDateTime creationDate;
}
