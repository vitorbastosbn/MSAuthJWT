package com.msauth.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Resposta contendo o token JWT")
public class TokenResponse {
    
    @Schema(description = "Token JWT para autenticação", example = "eyJhbGciOiJIUzI1NiJ9...")
    private String token;
    
    @Schema(description = "Tipo do token", example = "Bearer")
    private String type = "Bearer";
} 