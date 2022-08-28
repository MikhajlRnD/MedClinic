package service;

import model.LogOperation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

public class Log implements LogService<Object> {


    @Override
    public void log(LogOperation operation, Object card) {
        Path path = Paths.get("C:/Users/Kris & Mishka/Desktop/Java med clinic/log.txt");
        String str = operation.getValue() + ": " + card + " " + LocalDateTime.now() + "\n";
        try (FileWriter writer = new FileWriter(String.valueOf(path), true);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            bufferedWriter.write(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
