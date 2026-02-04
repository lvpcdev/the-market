package controller;

import model.entities.User;
import service.BuyService;
import service.ProductService;

import java.util.Scanner;

public class BuyController {

    private ProductService productService = new ProductService();
    private BuyService buyService = new BuyService();

    private Scanner sc = new Scanner(System.in);

    public void buy(User user) {
        System.out.println("Insira o código do produto que deseja realizar a compra:");
        int code = Integer.parseInt(sc.nextLine());


        System.out.println("Deseja comprar o produto abaixo? (s/n)");
        System.out.println(productService.foundProduct(code));

        char option = sc.nextLine().charAt(0);

        if (String.valueOf(option).equalsIgnoreCase("s")) {
            buyService.buy(user,code);
        }
    }
}
