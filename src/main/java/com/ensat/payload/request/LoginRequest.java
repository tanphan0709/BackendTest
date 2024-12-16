package com.ensat.payload.request;

import lombok.Data;

@Data
public class LoginRequest {
    private String user;
    private String pass;
}
