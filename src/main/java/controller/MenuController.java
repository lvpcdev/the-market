package controller;

import model.entities.User;
import model.enums.UserType;

import java.util.Scanner;

public class MenuController {

    private Scanner sc = new Scanner(System.in);
    private ProductController productController = new ProductController();
    private BuyController buyController = new BuyController();
    private int option;

    public void start(User user) {
        if (user.getUserType().equals(UserType.FUNCIONARIO)) {
            employeeMenu(user);
        } else if (user.getUserType().equals(UserType.CLIENTE)) {
            clientMenu(user);
        }
    }

    private void employeeMenu(User user) {
        do {
            System.out.println("Bem vindo(a) " + user.getName() + " Selecione uma das opções abaixo:" +
                    "\n\n1)Visualizar produtos cadastrados" +
                    "\n2)Cadastrar produto" +
                    "\n3)Sair");

            option = sc.nextInt();

            switch (option) {
                case 1 -> productController.listAllProducts();
                case 2 -> productController.registerProduct(user);
                case 3 -> System.out.println("Saindo...");
            }
        } while (option != 3);
    }

    private void clientMenu(User user) {
        do {


            System.out.println("Bem vindo(a) " + user.getName() + " Selecione uma das opções abaixo:" +
                    "\n\n1)Visualizar produtos" +
                    "\n2)Comprar produto" +
                    "\n3)Sair");

            int option = sc.nextInt();

            switch (option) {
                case 1 -> productController.listAllProducts();
                case 2 -> buyController.buy(user);
                case 3 -> System.out.println("Saindo...");
            }
        } while (option != 3);
    }
}
