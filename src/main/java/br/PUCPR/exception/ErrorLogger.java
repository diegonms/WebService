package br.PUCPR.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class ErrorLogger {

    private final File errorFile = new File("src/main/resources/errors.json");
    private final ObjectMapper mapper = new ObjectMapper();

    // Adiciona o erro ao JSON, sem apagar os existentes
    public synchronized void logError(String code, String message) {
        try {
            Map<String, Object> existingErrors = new LinkedHashMap<>();

            // Se o arquivo já existe e tem conteúdo, lê ele
            if (errorFile.exists() && errorFile.length() > 0) {
                byte[] jsonData = Files.readAllBytes(errorFile.toPath());
                existingErrors = mapper.readValue(jsonData, LinkedHashMap.class);
            }

            // Cria uma entrada nova com timestamp
            Map<String, String> errorData = new LinkedHashMap<>();
            errorData.put("message", message);
            errorData.put("timestamp", LocalDateTime.now().toString());

            // Atualiza o JSON em memória
            existingErrors.put(code, errorData);

            // Escreve de volta no arquivo
            mapper.writerWithDefaultPrettyPrinter().writeValue(errorFile, existingErrors);

        } catch (IOException e) {
            System.err.println("Erro ao atualizar errors.json: " + e.getMessage());
        }
    }
}
