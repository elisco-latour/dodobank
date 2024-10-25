package com.dodobank.dodobank_bff.auth;

import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.cookie;

import com.dodobank.dodobank_bff.auth.application.LoginUseCase;
import com.dodobank.dodobank_bff.auth.domain.entities.LoginRequest;
import com.dodobank.dodobank_bff.auth.domain.entities.LoginResponse;
import com.dodobank.dodobank_bff.auth.presentation.AuthController;


@WebMvcTest(AuthController.class)
public class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LoginUseCase loginUseCase;

    @Test
    void login_shouldSetHttpOnlyCookieWithAccessToken() throws Exception {
        // Given a valid login request and access token
        LoginRequest loginRequest = new LoginRequest(
                "john.doe@example.com",
                "P@ssW0rd!");
        LoginResponse loginResponse = new LoginResponse();

        // Mock the SignInUseCase
        when(loginUseCase.execute(loginRequest)).thenReturn(loginResponse);

        // Verify that the login sets an HttpOnly cookie with an acess token
        mockMvc.perform(post("/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(loginRequest.toJson()))
                .andExpect(status().isOk())
                .andExpect(cookie().exists("access_token"))
                .andExpect(cookie().value("access_token", "some-access-token"))
                .andExpect(cookie().httpOnly("access_token", true));
    }
}
