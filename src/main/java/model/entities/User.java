package model.entities;

import model.enums.UserType;

import java.util.Objects;

public class User implements Comparable<User>{

    private String name;
    private String cpf;
    private String password;
    private UserType userType;

    public User(String name, String cpf, String password, UserType userType) {
        this.name = name;
        this.cpf = cpf;
        this.password = password;
        this.userType = userType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(cpf, user.cpf) && Objects.equals(password, user.password) && userType == user.userType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cpf, password, userType);
    }


    @Override
    public int compareTo(User o) {
        return name.toUpperCase().compareTo(o.getName().toUpperCase());
    }
}
