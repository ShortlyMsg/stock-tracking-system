package com.trackingsys.stocktrackingsystem.entity;

import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_id")
    private long productId;

    @NotNull
    @Column(name="product_name")
    private String productName;

    @NotNull
    @Column(name="unit_stock")
    private int unitStock;

    @NotNull
    @Column(name="unit_price")
    private double unitPrice;

    @NotNull
    @Column(name="inventory")
    private String inventory;

    @NotNull
    @Column(name="stock_status")
    private boolean stockStatus;

/*    @ManyToOne()
    @JoinColumn(name="category_id")
    private Category category;*/

}
