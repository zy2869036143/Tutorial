package com.sdu.supportteach.request;

import cn.hutool.json.JSONArray;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class PicSaveRequest {
    @NotBlank(message = "Pictures shouldn't be blank!")
    private JSONArray pictures;
}
