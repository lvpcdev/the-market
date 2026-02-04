package service;

import dao.ProductDao;
import model.entities.Product;
import model.entities.User;
import model.enums.UserType;

import java.util.Set;

public class ProductService {
    private ProductDao productDao = new ProductDao();

    public void registerProduct(User user, Product product) {
        if (user.getUserType() != UserType.FUNCIONARIO) {
            throw new RuntimeException("Somente funcionário podem cadastrar produtos");
        }

        if (product.getPrice() <= 0) {
            throw new RuntimeException("Preço inválido");

        }

        productDao.create(product);
    }

    public Set<Product> listAll() {
        return productDao.findAll();
    }

    public Product foundProduct(int code) {
        Product product = productDao.read(code);

        if (product == null) {
            throw new RuntimeException("Produto não encontrado");
        }

        return product;
    }}
