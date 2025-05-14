package edu.zahr.websec.auth;

/*
@author ivan
@project IntelliJ IDEA 
@class AuthenticationResponse
@version 1.0.0 
@since 14.05.2025 - 21.33
*/

import lombok.*;

@Builder
@Getter
@Setter
public class AuthenticationResponse {
    private String token;
}