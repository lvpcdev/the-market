package dao;

import model.entities.Product;


import java.io.*;
import java.util.Set;
import java.util.TreeSet;

public class ProductDao {


    private static final String dirPath = "C:\\temp";
    private static final String filePath = "C:\\temp\\product.txt";


    public void verificator() {
        File directorie = new File(dirPath);
        File file = new File(filePath);

        try {
            if (!directorie.exists()) {
                directorie.mkdir();
            }

            if (!file.exists()) {
                file.createNewFile();

            }
        } catch (IOException e) {
            System.out.println("Erro ao criar arquivo: " + e.getMessage());

        }
    }


    public void create(Product product) {
        verificator();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {

            String line = product.getCode() + "," + product.getName() + "," + product.getPrice();

            bw.write(line);
            bw.newLine();


        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public Product read(Integer code) {
        verificator();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line = br.readLine();
            boolean found = false;
            while (line != null || found == false) {
                String[] fields = line.split(",");
                if (Integer.parseInt(fields[0]) == code) {
                    found = true;
                    Product product = new Product(fields[1],Double.parseDouble(fields[2]),Integer.parseInt(fields[0]));
                    return product;
                }
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return null;
    }



    public Set<Product> findAll() {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            Set<Product> products = new TreeSet<>();
            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(",");
                Product product = new Product(fields[1],Double.parseDouble(fields[2]),Integer.parseInt(fields[0]));

                products.add(product);
                line = br.readLine();
            }
            return products;
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return null;
    }
}
