package org.example.jwt;

import org.springframework.security.core.AuthenticationException;

public class JwtException extends AuthenticationException {
    public JwtException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public JwtException(String msg) {
        super(msg);
    }
}
