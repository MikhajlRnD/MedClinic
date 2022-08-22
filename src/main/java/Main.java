import configuration.ConnectionPG;

import configuration.TableCreate;
import model.DoctorCard;
import service.DoctorCardService;
import service.DoctorCardServicePostgres;

import java.sql.*;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        TableCreate.createTable();

        DoctorCardService doctorCard = new DoctorCardServicePostgres();

        DoctorCard doctorCardOne = new DoctorCard();
        doctorCardOne.setId(1L);
        doctorCardOne.setName("Сидоров сидор сидовроич");
        doctorCardOne.setDateOfBirth(LocalDate.of(1992, 10, 10));

        doctorCardOne.setSpecialization("терапевт");
        doctorCardOne.setWorkExperience(8);
        doctorCardOne.setLastUpdatedDate(LocalDateTime.now());
        System.out.println(doctorCardOne.getDateOfBirth());
        System.out.println(doctorCardOne.getLastUpdatedDate());

        //doctorCard.create(doctorCardOne);
        doctorCard.update(1L, doctorCardOne);

        //doctorCard.delete(1L);


    }
}


