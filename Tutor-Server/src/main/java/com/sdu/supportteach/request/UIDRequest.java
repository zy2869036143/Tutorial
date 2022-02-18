package com.sdu.supportteach.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UIDRequest {
    @NotBlank(message = "User id shouldn't be blank!")
    private int userId;
}
