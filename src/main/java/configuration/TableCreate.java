package configuration;

import lombok.Data;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Data

public class TableCreate {
    public static final String SQL_CREATE = "CREATE TABLE IF NOT EXISTS doctor_card"
            + "("
            + " ID int PRIMARY KEY,"
            + " NAME varchar(200) NOT NULL,"
            +  "DATE_OF_BIRTH date NOT NULL,"
            + " SPECIALIZATION varchar(200) NOT NULL,"
            + " WORK_EXPERIENCE int NOT NULL,"
            + " DATE_OF_CREATE timestamp NOT NULL"
            + ")";
    public static void createTable() {
        try (Connection connect = ConnectionPG.connect(); Statement stmt = connect.createStatement()){
            stmt.executeUpdate(SQL_CREATE);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
