package com.lance.dto;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class UserAddDTO {

    @NotEmpty(message = "Username must not be empty")
    @Length(min = 5, max = 16, message = "Username length must be 5~16 digits")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "Username must be alphanumeric")
    private String username;

    @NotEmpty(message = "Password must not be empty")
    @Length(min = 4, max = 16, message = "Username length must be 4~16 digits")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}