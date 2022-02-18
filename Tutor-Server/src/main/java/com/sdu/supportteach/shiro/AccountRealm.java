package com.sdu.supportteach.shiro;

import cn.hutool.core.bean.BeanUtil;
import com.sdu.supportteach.entity.Users;
import com.sdu.supportteach.service.UsersService;
import com.sdu.supportteach.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AccountRealm extends AuthorizingRealm {
    @Autowired
    UsersService usersService;
    @Autowired
    JwtUtil jwtUtil;


    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        JwtToken jwt = (JwtToken) token;
        log.info("jwt----------------->{}", jwt);
        String userId = jwtUtil.getClaimsByToken((String) jwt.getPrincipal()).getSubject();
        Users user = usersService.getById(Long.parseLong(userId));
        if(user == null) {
            throw new UnknownAccountException("The Account doesn't exist!");
        }
//        if(user.getStatus() == -1) {
//            throw new LockedAccountException("账户已被锁定！");
//        }
        AccountProfile profile = new AccountProfile();
        BeanUtil.copyProperties(user, profile);
        log.info("profile----------------->{}", profile.toString());
        return new SimpleAuthenticationInfo(profile, jwt.getCredentials(), getName());

    }
}
