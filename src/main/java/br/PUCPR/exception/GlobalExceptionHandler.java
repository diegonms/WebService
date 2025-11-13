package br.PUCPR.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    private ErrorMessageLoader messageLoader;

    @Autowired
    private ErrorLogger errorLogger;

    // 🔹 Trata exceções de negócio (BusinessException)
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Map<String, Object>> handleBusinessException(BusinessException ex) {
        Map<String, Object> response = new HashMap<>();

        // Obtém código e mensagem do erro
        String code = ex.getCode();
        String message = messageLoader != null
                ? messageLoader.getMessage(code)
                : ex.getMessage();

        // Grava o erro automaticamente no errors.json
        if (errorLogger != null) {
            errorLogger.logError(code, message);
        }

        // Monta a resposta HTTP
        response.put("code", code);
        response.put("message", message);
        response.put("timestamp", LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    // 🔹 Trata exceções genéricas (erros inesperados)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGenericException(Exception ex) {
        Map<String, Object> response = new HashMap<>();

        String code = "INTERNAL_ERROR";
        String message = "Ocorreu um erro inesperado: " + ex.getMessage();

        // Registra o erro genérico no JSON
        if (errorLogger != null) {
            errorLogger.logError(code, message);
        }

        response.put("code", code);
        response.put("message", message);
        response.put("timestamp", LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
