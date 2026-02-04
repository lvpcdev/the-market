package controller;


import model.entities.User;
import service.AuthService;


import java.util.Scanner;

public class LoginController {

    private AuthService authService = new AuthService();
    private Scanner sc = new Scanner(System.in);

    public User login() {

        System.out.println("Informe seu o cpf: (somente numeros)");
        String cpf = sc.nextLine();
        System.out.println("Informe sua senha:");
        String password = sc.nextLine();

        return authService.auth(cpf,password);
    }
}
