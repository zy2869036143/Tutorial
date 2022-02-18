package com.sdu.supportteach.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author lzyu
 * @since 2022-01-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String account;

    private String password;

    private Integer loginCount;

    private String gender;

    private String name;

    private String avatar;

    private String university;

    private String major;

    private String desck;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastLogin;
}
