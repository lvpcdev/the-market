package controller;


import model.enums.UserType;
import service.RegisterService;

import java.util.Scanner;

public class RegisterController {

    private Scanner sc = new Scanner(System.in);
    private RegisterService registerService = new RegisterService();

    public void register() {

        System.out.println("Informe seu o nome:");
        String name = sc.nextLine();
        System.out.println("Informe seu o cpf: (somente numeros)");
        String cpf = sc.next();
        System.out.println("Informe sua senha:");
        String password = sc.next();
        System.out.println("Você é funcionário ou cliente do the market? (f/c)");
        char option = sc.next().charAt(0);
        UserType userType = null;

        if (String.valueOf(option).equalsIgnoreCase("f")) {
            userType = UserType.FUNCIONARIO;
        } else if (String.valueOf(option).equalsIgnoreCase("c")) {
            userType = UserType.CLIENTE;
        }

        registerService.register(name,cpf,password,userType);
    }
}
