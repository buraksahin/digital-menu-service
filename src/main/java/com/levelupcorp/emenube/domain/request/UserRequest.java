package com.levelupcorp.emenube.domain.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest implements Serializable {
    @JsonProperty("name")
    private String name;
    @JsonProperty("mail")
    private String mail;
    @JsonProperty("password")
    private String password;
    @JsonProperty("last_login")
    private Date lastLogin;
    @JsonProperty("auth_code")
    private String authCode;
    @JsonProperty("type")
    private Integer type;
}
