package br.PUCPR.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

@Component
public class ErrorMessageLoader {

    private Map<String, String> messages;

    public ErrorMessageLoader() {
        try (InputStream input = getClass().getResourceAsStream("/errors.json")) {
            ObjectMapper mapper = new ObjectMapper();
            this.messages = mapper.readValue(input, Map.class);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar mensagens de erro do arquivo JSON.", e);
        }
    }

    public String getMessage(String code) {
        return messages.getOrDefault(code, "Erro desconhecido (" + code + ")");
    }
}
