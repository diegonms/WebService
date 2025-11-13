package br.PUCPR.controller;

import br.PUCPR.exception.BusinessException;
import br.PUCPR.model.User;
import br.PUCPR.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@Tag(name = "Usuário", description = "APIs de gerenciamento de usuários")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    @Operation(summary = "Salva um usuário", description = "Insere um novo funcionário no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Usuário salvo com sucesso!"),
            @ApiResponse(responseCode = "400", description = "Dados incorretos.")
    })
    public ResponseEntity<User> save(@Valid @RequestBody User user) {

        //exception para impedir duplicatas nos emails
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new BusinessException("EMAIL_DuPLICADO", "Já existe um usuario com este email");
        }
        if (user.getPassword() == null || user.getPassword().isBlank()) {
            return ResponseEntity.badRequest().build();
        }

        // função de criar o hash ara impedir a senha crua no banco
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        // evita que o hash seja feito em cima de uma senha ja haseada - evita b.o :P
        String raw = user.getPassword();
        if (!raw.startsWith("$2a$") && !raw.startsWith("$2b$") && !raw.startsWith("$2y$")) {
            user.setPassword(encoder.encode(raw));
        }

        User novo = userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo);
    }
    public ResponseEntity<User> save(@Valid @RequestBody User user) {

    }

    @GetMapping
    @Operation(summary = "Lista todos os usuários", description = "Retorna todos os funcionários cadastrados")
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca usuário por ID")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        return userRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um usuário existente")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User dados) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setNome(dados.getNome());
                    user.setEmail(dados.getEmail());
                    user.setPassword(dados.getPassword());
                    user.setCargo(dados.getCargo());
                    return ResponseEntity.ok(userRepository.save(user));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Exclui um usuário")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
