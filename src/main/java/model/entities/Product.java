package model.entities;

import model.enums.UserType;

import java.util.Objects;

public class Product implements Comparable<Product>{

    private Integer code;
    private String name;
    private Double price;

    public Product(String name, Double price, Integer code) {
        this.name = name;
        this.price = price;
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "\nNome: " + name +
                "\nCódigo: " + code +
                "\nPreço: " + price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(code, product.code) && Objects.equals(name, product.name) && Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name, price);
    }

    @Override
    public int compareTo(Product o) {
        return name.toUpperCase().compareTo(o.getName().toUpperCase());
    }
}
