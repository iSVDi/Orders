package com.example.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity(name = "storeOrder")
@Getter
@JsonView
@NoArgsConstructor
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    private String info;

    @Positive
    @NotNull
    private BigDecimal amount;

    @NotBlank
    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @Setter
    @JsonIgnore
    private User user;

}
