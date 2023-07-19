package com.cryptoexchange.customer.model;

import com.cryptoexchange.customer.enums.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    @ElementCollection(targetClass = Role.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    private List<Role> rolesList;
    private boolean isVerified;
    private String phoneNumber;
    private String email;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private byte[] avatar;
}
