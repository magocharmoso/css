package pt.ul.fc.css.tascaeats.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import pt.ul.fc.css.tascaeats.DTOs.UserDTO;
import pt.ul.fc.css.tascaeats.entities.user.User;
import pt.ul.fc.css.tascaeats.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // A: login com autenticação mock
    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password) {
        if (userService.verifyUserExists(email)) {
            return "Utilizador autenticado com sucesso.";
        }
        return "Falha na autenticação: utilizador não encontrado.";
    }

    // B: registo de utilizadores
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO register(@RequestBody @Valid UserUpsertRequest req) {
        User user = userService.register(req.name(), req.email(), req.role());
        return new UserDTO(user);
    }

    // C.1: verificar utilizador
    @GetMapping("/{id}")
    public UserDTO getById(@PathVariable Long id) {
        return new UserDTO(userService.getUserById(id));
    }

    // C.2: remover utilizador
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        userService.removeUser(id);
    }

    // C.3: atualizar utilizador
    @PutMapping("/{id}")
    public UserDTO update(@PathVariable Long id, @RequestBody @Valid UserUpsertRequest req) {
        User user = userService.updateUser(id, req.name(), req.email(), req.role());
        return new UserDTO(user);
    }

    public record UserUpsertRequest(String name, String email, String role) {
    }
}
