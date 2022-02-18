package com.sdu.supportteach.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class EditPasswordRequest implements Serializable {
    @NotBlank
    private int userId;
    @NotBlank
    private String newPassword;
    @NotBlank
    private String oldPassword;
}
