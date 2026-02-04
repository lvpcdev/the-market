package controller;


import model.entities.User;
import service.AuthService;


import java.util.Scanner;

public class LoginController {

    private AuthService authService = new AuthService();
    private Scanner sc = new Scanner(System.in);

    public User login() {

        System.out.println("Informe seu o cpf: (somente numeros)");
        String cpf = sc.next();
        System.out.println("Informe sua senha:");
        String password = sc.next();

        return authService.auth(cpf,password);
    }
}
