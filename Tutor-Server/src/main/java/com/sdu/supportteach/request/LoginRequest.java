package com.sdu.supportteach.request;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class LoginRequest implements Serializable {
    @NotBlank(message = "Account shouldn't be blank!")
    @NotNull(message = "Account shouldn't be null!")
    private String account;
    @NotNull(message = "Password shouldn't be null!")
    @NotBlank(message = "Password shouldn't be blank")
    private String password;

}
