package com.javamentor.service.security;

import com.javamentor.model.Role;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collection;

@Service
public class AuthSuccessHandler implements AuthenticationSuccessHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {

        handle(httpServletRequest, httpServletResponse, authentication);
        clearAuthenticationAttributes(httpServletRequest);

    }

    private void handle(HttpServletRequest req, HttpServletResponse resp, Authentication auth) {

        String targetUrl = getTargetUrl(auth);

    }

    private void clearAuthenticationAttributes(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return;
        }
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }

    private String getTargetUrl(Authentication auth) {

        Collection<?> authorities = auth.getAuthorities();

        if (authorities.contains(new Role("ADMIN"))) {
            return "/adm";
        } else if (authorities.contains(new Role("USER"))) {
            return "/index";
        } else {
            throw new IllegalStateException();
        }

    }

}

