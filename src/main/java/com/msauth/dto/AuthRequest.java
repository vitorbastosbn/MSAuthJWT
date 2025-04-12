package com.msauth.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dados de autenticação do usuário")
public class AuthRequest {
    
    @Schema(description = "Nome de usuário", example = "usuario123")
    private String username;
    
    @Schema(description = "Senha do usuário", example = "senha123")
    private String password;
} 