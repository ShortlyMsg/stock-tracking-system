package com.trackingsys.stocktrackingsystem.dto;

import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.ZoneId;

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
