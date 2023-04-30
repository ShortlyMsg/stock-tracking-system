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
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name="order_id")
    private String orderId;

    @NotNull
    @Column(name="order_number")
    private String orderNumber;

    @NotNull
    @Column(name="order_date")
    private LocalDateTime orderDate = LocalDateTime.now(ZoneId.of("Africa/Addis_Ababa"));

}
