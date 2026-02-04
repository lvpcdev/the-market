package controller;


import model.entities.Product;
import model.entities.User;
import service.ProductService;

import java.util.Scanner;

public class ProductController {

    private ProductService productService = new ProductService();
    private Scanner sc = new Scanner(System.in);

    public void registerProduct(User user) {
        System.out.println("Insira o código do produto que deseja registrar:");
        int code = sc.nextInt();
        System.out.println("Insira o nome do produto que deseja registrar:");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.println("Insira o preço do produto que deseja registrar:");
        double price = sc.nextDouble();

        Product product = new Product(name,price,code);

        System.out.println("Deseja cadastrar o produto abaixo? (s/n)");
        System.out.println(product);

        char option = sc.next().charAt(0);

        if (String.valueOf(option).equalsIgnoreCase("s")) {
            productService.registerProduct(user,product);
        }
    }


    public void listAllProducts() {
        System.out.println(productService.listAll());
    }
}
