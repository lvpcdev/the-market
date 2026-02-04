package controller;

import model.entities.User;

import java.util.Scanner;

public class UserController {

    private Scanner sc = new Scanner(System.in);
    private RegisterController registerController = new RegisterController();
    private LoginController loginController = new LoginController();
    private int option;


    public User start() {

        do {
            System.out.println("Bem vindo ao The Market selecione uma das opções abaixo:" +
                    "\n\n1)Realizar login" +
                    "\n2)Realizar cadastro" +
                    "\n3)Sair");

            option = Integer.parseInt(sc.nextLine());

            switch (option) {
                case 1 -> {
                    return loginController.login();
                }
                case 2 -> registerController.register();
                case 3 -> System.out.println("Saindo do sistema");
                default -> System.out.println("Erro: numero digitado inválido");
            }

        } while (option != 3);

        return null;
    }

    public int option() {
        return option;
    }


}
