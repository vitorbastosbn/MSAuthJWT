package com.msauth.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msauth.dto.ApiResponse;
import com.msauth.dto.AuthRequest;
import com.msauth.dto.TokenResponse;
import com.msauth.service.AuthService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Tag(name = "Autenticação", description = "APIs para autenticação e registro de usuários")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    @Operation(summary = "Registrar novo usuário", description = "Cria um novo usuário e retorna um token JWT")
    @ApiResponses(value = {
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "Usuário registrado com sucesso"),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Dados inválidos"),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "409", description = "Usuário já existe")
    })
    public ResponseEntity<ApiResponse<TokenResponse>> register(@RequestBody AuthRequest request) {
        try {
            authService.register(request);
            return ResponseEntity
                    .status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(ApiResponse.error(409, "Usuário já existe"));
        }
    }

    @PostMapping("/login")
    @Operation(summary = "Autenticar usuário", description = "Autentica um usuário existente e retorna um token JWT")
    @ApiResponses(value = {
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Login realizado com sucesso"),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Credenciais inválidas"),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    })
    public ResponseEntity<ApiResponse<TokenResponse>> login(@RequestBody AuthRequest request) {
        try {
            String token = authService.authenticate(request);
            TokenResponse tokenResponse = new TokenResponse();
            tokenResponse.setToken(token);
            return ResponseEntity.ok(ApiResponse.success(tokenResponse));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(ApiResponse.error(401, "Credenciais inválidas"));
        }
    }

    @PostMapping("/test-token")
    @Operation(summary = "Gerar token de teste", description = "Gera um token JWT válido para testes no Swagger")
    @ApiResponses(value = {
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "Token gerado com sucesso"),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "409", description = "Usuário de teste já existe")
    })
    public ResponseEntity<ApiResponse<TokenResponse>> generateTestToken() {
        try {
            authService.register(new AuthRequest("test", "test"));
            return ResponseEntity
                    .status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(ApiResponse.error(409, "Usuário de teste já existe"));
        }
    }
} 