package br.PUCPR;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;
import java.sql.Connection;

@Component
public class DatabaseTest implements CommandLineRunner {

    private final DataSource dataSource;

    public DatabaseTest(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void run(String... args) throws Exception {
        try (Connection conn = dataSource.getConnection()) {
            System.out.println("✅ Conexão com MySQL estabelecida com sucesso!");
            System.out.println("✅ Database: " + conn.getCatalog());
        } catch (Exception e) {
            System.out.println("❌ Erro na conexão com MySQL: " + e.getMessage());
        }
    }
}