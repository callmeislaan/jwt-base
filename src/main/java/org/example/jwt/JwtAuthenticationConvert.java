package org.example.jwt;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationConverter;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class JwtAuthenticationConvert implements AuthenticationConverter {

    @Override
    public Authentication convert(HttpServletRequest request) {
        String token = getToken(request);
        String username = JwtUtil.getUsernameFromJWT(token);
        return new JwtAuthenticationToken(token, username);
    }

    private String getToken(HttpServletRequest request) {
        String AUTHOR_HEADER = "Authorization";
        String BEARER_SPACE = "Bearer ";
        String tokenHeader = request.getHeader(AUTHOR_HEADER);
        if (tokenHeader != null && tokenHeader.startsWith(BEARER_SPACE)) {
            return tokenHeader.substring(7);
        } else {
            throw new JwtException("Bearer string not found in token");
        }
    }

}
