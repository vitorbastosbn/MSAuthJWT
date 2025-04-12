package com.msauth.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Resposta padrão da API")
public class ApiResponse<T> {
    
    @Schema(description = "Código HTTP da resposta", example = "200")
    private int status;
    
    @Schema(description = "Mensagem descritiva da resposta", example = "Operação realizada com sucesso")
    private String message;
    
    @Schema(description = "Dados da resposta")
    private T data;
    
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(200, "Operação realizada com sucesso", data);
    }
    
    public static <T> ApiResponse<T> created(T data) {
        return new ApiResponse<>(201, "Recurso criado com sucesso", data);
    }
    
    public static <T> ApiResponse<T> error(int status, String message) {
        return new ApiResponse<>(status, message, null);
    }
} 