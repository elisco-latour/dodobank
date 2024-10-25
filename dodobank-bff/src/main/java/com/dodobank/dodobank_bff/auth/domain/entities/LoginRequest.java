package com.dodobank.dodobank_bff.auth.domain.entities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LoginRequest {

    public LoginRequest(String email, String passWord) {
        this.email = email;
        this.passWord = passWord;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassWord() {
        return this.passWord;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String toJson() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(this);

        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error while converting request to JSON ", e);
        }
    }

    private String email;
    private String passWord;

}
