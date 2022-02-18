//package com.sdu.supportteach.config;
//
//import com.sdu.supportteach.shiro.JwtFilter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(
//        // securedEnabled = true,
//        // jsr250Enabled = true,
//        prePostEnabled = true)
//public class WebSecurityConfig  extends WebSecurityConfigurerAdapter  {
////    @Bean
////    public JwtFilter authenticationJwtTokenFilter() {
////        return new JwtFilter();
////    }hdrgfsdrgfsdsdg
////    @Override
////    protected void configure(HttpSecurity http) throws Exception {
////        http.cors().and().csrf().disable()
////                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
////                .authorizeRequests().antMatchers("/**").permitAll()
////                .anyRequest().permitAll();
////
////        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
////    }
////    @Override
////    public void configure(WebSecurity webSecurity) throws Exception {
////        webSecurity.ignoring().antMatchers("/index.html","/css/**", "/js/**","/css/**","/img/**","/favicon.ico");
////    }
//}
