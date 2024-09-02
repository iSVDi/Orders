package com.example.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity (name = "storeUser")
@Getter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JsonView(UserViews.UserSummary.class)
    private UUID id;
    @JsonView(UserViews.UserSummary.class)
    private String name;
    @JsonView(UserViews.UserSummary.class)
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    @JsonView(UserViews.UserDetails.class)
    private List<Order> orders;
}
