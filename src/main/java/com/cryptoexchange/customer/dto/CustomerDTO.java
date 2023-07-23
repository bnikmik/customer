package com.cryptoexchange.customer.dto;

import com.cryptoexchange.customer.enums.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.net.URL;
import java.util.List;

@Getter
@Setter
public class CustomerDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    private List<Role> rolesList;
    private boolean isVerified;
    private String phoneNumber;
    private String email;
    private URL avatarLink;
}
