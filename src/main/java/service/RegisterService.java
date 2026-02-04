package service;

import dao.UserDao;
import model.entities.User;
import model.enums.UserType;

public class RegisterService {
    private UserDao userDao = new UserDao();

    public void register(String name, String cpf, String password, UserType userType) {

        if (cpf == null || cpf.isBlank()) {
            throw new RuntimeException("Cpf inválido");
        }

        if (password.length() < 4) {
            throw new RuntimeException("Senha não pode ter menos que 4 caracteres");
        }

        if (userDao.userExist(cpf)) {
            throw new RuntimeException("Usuário já cadastrado");
        }

        User user = new User(name,cpf,password, userType);
        userDao.create(user);
    }

    }
