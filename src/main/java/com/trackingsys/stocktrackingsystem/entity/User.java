package com.trackingsys.stocktrackingsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;
import java.time.LocalDateTime;
import java.time.ZoneId;


@AllArgsConstructor
@NoArgsConstructor(force = true)
@Getter
@Setter
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "user_id")
    private String userId;

    @NotNull
    @Column(name = "mail")
    private String mail;

    @NotNull
    @Column(name = "password")
    private String password;

    @Column(name = "creation_date")
    private LocalDateTime creationDate= LocalDateTime.now(ZoneId.of("Africa/Addis_Ababa"));

}
