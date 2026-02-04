package utils;

import java.io.File;
import java.io.IOException;

public class FileUtils {

    public final static void verificator(String dirPath, String filePath) {
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
}
