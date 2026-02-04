package model.entities;

import model.enums.UserType;

public class Product {

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
        return "Dados do produto: " +
                "\n\nNome: " + name +
                "\nCódigo: " + code +
                "\nPreço: " + price;
    }
}
