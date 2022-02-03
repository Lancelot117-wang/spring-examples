package com.lance.service.impl;

import com.lance.service.MyService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

@Component
public class MyServiceImpl implements MyService {

    @Override
    public boolean hasPermission(HttpServletRequest httpServletRequest, Authentication authentication) {
        Object object = authentication.getPrincipal();
        if(object instanceof UserDetails){
            UserDetails userDetails = (UserDetails) object;
            Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
            return authorities.contains(new SimpleGrantedAuthority(httpServletRequest.getRequestURI()));
        }
        return false;
    }
}
