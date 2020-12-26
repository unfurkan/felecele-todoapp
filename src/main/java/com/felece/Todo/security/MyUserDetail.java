package com.felece.Todo.security;

import com.felece.Todo.user.UserModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyUserDetail implements UserDetails {
    private Integer userId;
    private String username;
    private String password;
    private List<GrantedAuthority> authorities =new ArrayList();
    public MyUserDetail(UserModel user){
        userId =user.getUserId();
        username =user.getUsername();
        password =user.getPassword();
        authorities.add(new SimpleGrantedAuthority(user.getRole()));

    }
    public MyUserDetail(){

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    public Integer getUserId() {
        return userId;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
