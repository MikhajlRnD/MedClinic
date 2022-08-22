import configuration.ConnectionPG;

import model.DoctorCard;
import service.DoctorCardServicePostgres;

import java.sql.*;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Connection connect = ConnectionPG.connect();
        DoctorCardServicePostgres doctorCard = new DoctorCardServicePostgres();
        doctorCard.createTabe();

        DoctorCard doctorCardOne = new DoctorCard();
        doctorCardOne.setId(1L);
        doctorCardOne.setName("Иванов Василий Иванович");
        doctorCardOne.setDateOfBirth(LocalDate.of(1991, 11, 21));
        doctorCardOne.setSpecialization("Хирург");
        doctorCardOne.setWorkExperience(10);
        doctorCardOne.setLastUpdatedDate(LocalDateTime.now());


        try {
            String sql = ("INSERT INTO doctor_card " +
                    "(ID, NAME, SPECIALIZATION, WORK_EXPERIENCE)"
                    + "VALUES (" + doctorCardOne.getId().intValue() + " ,"
                    + "'" + doctorCardOne.getName() +  "',"
                    + "'" + doctorCardOne.getSpecialization() + "',"
                    + doctorCardOne.getWorkExperience()) + ")";

            PreparedStatement insert = connect.prepareStatement(sql);
            System.out.println(sql);
            insert.executeQuery();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(Arrays.toString(e.getStackTrace()));
        }


    }
}


