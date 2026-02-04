package dao;

import model.entities.Product;
import utils.FIleUtils;


import java.io.*;
import java.util.Set;
import java.util.TreeSet;

public class ProductDao {


    private static final String dirPath = "C:\\temp";
    private static final String filePath = "C:\\temp\\product.txt";



    public void create(Product product) {
        FIleUtils.verificator(dirPath,filePath);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {

            String line = product.getCode() + "," + product.getName() + "," + product.getPrice();

            bw.write(line);
            bw.newLine();


        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public Product read(Integer code) {
        FIleUtils.verificator(dirPath,filePath);

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
        FIleUtils.verificator(dirPath,filePath);

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

    public boolean productExists(int code) {
        FIleUtils.verificator(dirPath,filePath);

        return findAll().stream()
                .anyMatch(p -> p.getCode().equals(code));
    }
}
