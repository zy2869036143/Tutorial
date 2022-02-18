package com.sdu.supportteach.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class BIDRequest implements Serializable {
    @NotBlank(message = "Blog id shouldn't be blank!")
    private int blogId;

    private int userId;
}
