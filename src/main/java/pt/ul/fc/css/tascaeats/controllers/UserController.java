package pt.ul.fc.css.tascaeats.controllers;

import pt.ul.fc.css.tascaeats.repository.UserRepository;
import pt.ul.fc.css.tascaeats.service.UserService;

public class UserController {

    public static final int NARGSA = 3;
    public static final int NARGSB = 4;
    public static final int NARGSC1 = 2;
    public static final int NARGSC2 = 3;
    public static final int NARGSC3 = 3;

    UserService userService;

    public UserController() {
        this.userService = new UserService(new UserRepository());
    }

    /**
     * A. Login com autenticação.
     * Faz autenticação em modo mock: qualquer palavra-passe é aceite,
     * desde que o utilizador exista e seja válido.
     */
    public String a(String email, String password) {
        try{
            if (userService.verifyUserExists(email)) {
                return "Utilizador autenticado com sucesso.\n";
            }
            else {
                return "Falha na autenticação: utilizador não encontrado.\n";
            }
        }catch (RuntimeException e) {
            return "Erro: " + e.getMessage() + "\n";
        }
    }

    /**
     * B. Registo de utilizadores.
     * Permite criar utilizadores do tipo Cliente, Administrador e Entregador.
     */
    public String b(String name, String email, String role) {
        try {
            userService.register(name, email, role);
            return "Utilizador registado com sucesso.\n";
        } catch (RuntimeException e) {
            return "Erro: " + e.getMessage() + "\n";
        }
    }

    /**
     * C.1 Verificar utilizadores.
     */
    public String c1(String email) {
        return "";
    }

    /**
     * C.2 Remover utilizadores.
     */
    public String c2() {
        return "";
    }

    /**
     * C.3 Atualizar utilizadores.
     */
    public String c3() {
        return "";
    }
}
