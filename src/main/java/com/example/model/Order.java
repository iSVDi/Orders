package com.example.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity(name = "storeOrder")
@Getter
@JsonView
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
    @JsonIgnore
    private User user;

}
