package service;

import dao.UserDao;
import model.entities.User;

public class AuthService {

    private UserDao userDao = new UserDao();

    public User auth(String cpf, String password) {
        User user = userDao.read(cpf);

        if (user == null) {
            throw new RuntimeException("Usuario não encontrado");
        }

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Senha inválida");
        }

        return user;
    }
}
