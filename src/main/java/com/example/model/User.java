package com.example.model;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity (name = "storeUser")
@Getter
@NoArgsConstructor
@Data

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JsonView(UserViews.UserSummary.class)

    private UUID id;

    @JsonView(UserViews.UserSummary.class)
    @NotBlank
    private String name;

    @JsonView(UserViews.UserSummary.class)
    @NotBlank
    @Email
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    @Setter
    @NotEmpty
    @NotNull
    @Valid
    private List<Order> orders;
}
