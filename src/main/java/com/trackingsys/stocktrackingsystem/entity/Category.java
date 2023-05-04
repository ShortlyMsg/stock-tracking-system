package com.trackingsys.stocktrackingsystem.entity;

import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Getter
@Setter
@Entity
@Table(name="category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="category_id")
    private int categoryId;

    @NotNull
    @Column(name="category_name")
    private String categoryName;

/*    @OneToMany(mappedBy = "category")
    private List<Product> products;*/

}
