package com.sdu.supportteach.controller;


import cn.hutool.core.map.MapUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.http.server.HttpServerResponse;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.sdu.supportteach.entity.Users;
import com.sdu.supportteach.request.EditPasswordRequest;
import com.sdu.supportteach.request.LoginRequest;
import com.sdu.supportteach.request.UIDRequest;
import com.sdu.supportteach.service.UsersService;
import com.sdu.supportteach.util.JwtUtil;
import com.sdu.supportteach.util.Result;
import io.jsonwebtoken.lang.Assert;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Security;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lzyu
 * @since 2022-01-10
 */
@RestController
@RequestMapping("/api")
public class UsersController {
    @Autowired
    UsersService usersService;
    @Autowired
    JwtUtil jwtUtil;

    @PostMapping("/login")
    public Result login (@Validated @RequestBody LoginRequest loginRequest, HttpServletResponse response){
        System.out.println(loginRequest.getAccount());
        Users user = usersService.getOne(new QueryWrapper<Users>().eq("account", loginRequest.getAccount()));
        Assert.notNull(user, "User doesn't exist");
        if (!user.getPassword().equals(SecureUtil.md5(loginRequest.getPassword()))){
            return Result.fail("Password wrong!");
        }
        String jwt = jwtUtil.generateToken(user.getId());
        response.setHeader("Authorization", jwt);
        response.setHeader("Access-Control-Expose-Headers", "Authorization");
        user.setLoginCount(user.getLoginCount()+1);
        user.setLastLogin(LocalDateTime.now());
        usersService.saveOrUpdate(user);
        return Result.success(MapUtil.builder()
                .put("id", user.getId())
                .put("token", jwt)
                .put("account", user.getAccount())
                .map()
        );
    }

    @PostMapping("/editPassword")
    public Result editPassword(@Validated @RequestBody EditPasswordRequest editPassword){
        int uid = editPassword.getUserId();
        String newPassword = editPassword.getNewPassword();
        String oldPassword = editPassword.getOldPassword();
        Users user = usersService.getById(uid);
        try {
            org.springframework.util.Assert.notNull(user, "用户不存在");
        }catch (IllegalArgumentException e){}
        String secure = SecureUtil.md5(oldPassword);
        if (user.getPassword().equals(secure)){
            System.out.println("修改密码成功");
            user.setPassword(SecureUtil.md5(newPassword));
            usersService.saveOrUpdate(user);
            return Result.success("修改密码成功");
        }
        return Result.fail("密码错误！");
    }

    @PostMapping("/update")
    public Result updateUserInfor(@Validated @RequestBody Users user){
        System.out.println("更新用户信息");
        Users u_ser = usersService.getById(user.getId());
        u_ser.setName(user.getName());
        u_ser.setGender(user.getGender());
        u_ser.setAvatar(user.getAvatar());
        u_ser.setUniversity(user.getUniversity());
        u_ser.setMajor(user.getMajor());
        u_ser.setDesck(user.getDesck());
        usersService.saveOrUpdate(u_ser);
        return Result.success("成功");
    }


    @PostMapping("/userInf")
    public Result getUserInfor(@Validated @RequestBody UIDRequest uidRequest){
        System.out.println("获取用户信息");
        return Result.success(usersService.getById(uidRequest.getUserId()));
    }

    @GetMapping("/user/{id}")
    public Object test(@PathVariable("id") Long id) {
        return usersService.getById(id);
    }

    @GetMapping("/logout")
    @RequiresAuthentication
    public Result logout() {
        System.out.println("log out");
        SecurityUtils.getSubject().logout();
        return Result.success("成功退出");
    }
}
