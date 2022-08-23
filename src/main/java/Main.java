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
        doctorCardOne.setId(2L);
        doctorCardOne.setName("Сидоров сидо стдорова");
        doctorCardOne.setDateOfBirth(LocalDate.of(1991, 11, 12));

        doctorCardOne.setSpecialization("хирург");
        doctorCardOne.setWorkExperience(2);
        doctorCardOne.setLastUpdatedDate(LocalDateTime.now());
        doctorCard.create(doctorCardOne);

        //System.out.println(doctorCard.getAll());

        System.out.println(doctorCard.getById(2L));


        //doctorCard.update(1L, doctorCardOne);

        //doctorCard.delete(1L);


    }
}


