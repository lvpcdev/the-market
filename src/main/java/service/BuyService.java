package service;

import dao.ProductDao;
import model.entities.Product;
import model.entities.User;
import model.enums.UserType;

public class BuyService {
    private ProductDao productDao = new ProductDao();

    public void buy(User user, int code) {
        if (user.getUserType() != UserType.CLIENTE) {
            throw new RuntimeException("Somente clientes do The Market podem realizar compras");
        }

        Product product = productDao.read(code);

        if (product == null) {
            throw new RuntimeException("Produto não encotrado");
        }

        System.out.println("Compra realizada com sucesso");
    }
}
