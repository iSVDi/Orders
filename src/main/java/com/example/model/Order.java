package com.example.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity(name = "storeOrder")
@Getter
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String info;
    private BigDecimal amount;
    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @Setter
    private User user;

}
