package br.PUCPR;

import br.PUCPR.model.User;
import br.PUCPR.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TesteBanco implements CommandLineRunner {

    private final UserRepository userRepository;

    public TesteBanco(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) {
        System.out.println("===== Testando conexão com o banco =====");
        userRepository.findAll().forEach(user ->
                System.out.println(user.getId() + " - " + user.getNome() + " - " + user.getEmail())
        );
        System.out.println("===== Fim do teste =====");
    }
}
