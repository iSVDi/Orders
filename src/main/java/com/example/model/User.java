package com.example.model;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity (name = "storeUser")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Generated
@Builder
public class User implements Cloneable{
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

    @Override
    public User clone() {
        try {
            User clone = (User) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
