package service;

import model.Card;
import model.DoctorCard;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

public class Log implements LogService {




    @Override
    public void creedLog(String operation, Card card, LocalDateTime time) {
        Path path = Paths.get("C:/Users/Kris & Mishka/IdeaProjects/untitled/MedClinic/src/log.txt");
        String str = operation + ": " +  card + " " + time + "\n";
        try {
            FileWriter writer = new FileWriter(String.valueOf(path), true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(str);
            bufferedWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
