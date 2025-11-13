package br.PUCPR.tools;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExportErrorMessages {
    public static void main(String[] args) throws IOException {
        // Caminho raiz do código-fonte
        Path srcPath = Paths.get("src/main/java/br/PUCPR");
        Map<String, String> messages = new LinkedHashMap<>();

        // Regex para capturar: new BusinessException("CODIGO", "Mensagem")
        Pattern pattern = Pattern.compile(
                "new\\s+BusinessException\\s*\\(\\s*\"(.*?)\"\\s*,\\s*\"(.*?)\"\\s*\\)"
        );

        // Varre todos os arquivos .java no projeto
        Files.walk(srcPath)
                .filter(path -> path.toString().endsWith(".java"))
                .forEach(file -> {
                    try {
                        String content = Files.readString(file);
                        Matcher matcher = pattern.matcher(content);
                        while (matcher.find()) {
                            String code = matcher.group(1);
                            String message = matcher.group(2);
                            messages.put(code, message);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

        if (messages.isEmpty()) {
            System.out.println("Nenhuma BusinessException encontrada!!");
            return;
        }

        // Usa o arquivo existente no resources
        File outputFile = new File("src/main/resources/errors.json");

        // Apenas reescreve (atualiza) o conteúdo com as mensagens novas
        new ObjectMapper()
                .writerWithDefaultPrettyPrinter()
                .writeValue(outputFile, messages);

        System.out.println("Arquivo errors.json atualizado com sucesso!");


        System.out.println("Arquivo errors.json gerado com sucesso!");
        System.out.println("Local: " + outputFile.getAbsolutePath());
        System.out.println("Total de mensagens encontradas: " + messages.size());
    }
}
