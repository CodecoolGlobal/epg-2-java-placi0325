package com.codecool.elproyectegrande.dao.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String clientName;
    private String password;
    @OneToMany( mappedBy = "seller")
    private List<Product> productsToSell;
    @OneToMany( mappedBy = "buyer")
    private List<Product> productsBought;
}
