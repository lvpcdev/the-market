package dao;

import model.entities.User;
import model.enums.UserType;
import utils.FIleUtils;

import java.io.*;
import java.util.Set;
import java.util.TreeSet;

public class UserDao {

    private static final String dirPath = "C:\\temp";
    private static final String filePath = "C:\\temp\\user.txt";


    public void create(User user) {
        FIleUtils.verificator(dirPath,filePath);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {

            String line = user.getUserType() + "," + user.getName() + "," + user.getCpf() + "," + user.getPassword();

            bw.write(line);
            bw.newLine();


        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public User read(String cpf) {
        FIleUtils.verificator(dirPath,filePath);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line = br.readLine();
            boolean found = false;
            while (line != null && found == false) {
                String[] fields = line.split(",");
                if (fields[2].equals(cpf)) {
                    found = true;
                    User user = new User(fields[1], fields[2], fields[3], UserType.valueOf(fields[0]));
                    return user;
                }
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return null;
    }


    public Set<User> findAll() {
        FIleUtils.verificator(dirPath,filePath);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            Set<User> users = new TreeSet<>();
            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(",");
                User user = new User(fields[1], fields[2], fields[3], UserType.valueOf(fields[0]));

                users.add(user);
                line = br.readLine();
            }
            return users;
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return null;
    }

    public boolean userExist(String cpf) {
        FIleUtils.verificator(dirPath,filePath);

        return findAll().stream()
                .anyMatch(u -> u.getCpf().equals(cpf));
    }

}
