package service;

import configuration.ConnectionPG;
import configuration.TableCreate;
import model.Card;
import model.DoctorCard;
import service.DoctorCardService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

public class DoctorCardServicePostgres implements DoctorCardService {
    @Override
    public void create(DoctorCard card) {
        try (Connection connect = ConnectionPG.connect(); Statement statement = connect.createStatement()) {
            String sql = ("INSERT INTO doctor_card " +
                    "(ID, NAME, DATE_OF_BIRTH, SPECIALIZATION, WORK_EXPERIENCE, DATE_OF_CREATE)"
                    + "VALUES (" + card.getId().intValue() + " ,"
                    + "'" + card.getName() +  "',"
                    + "'" + card.getDateOfBirth() + "' ,"
                    + "'" + card.getSpecialization() + "',"
                    + "'" + card.getWorkExperience() + "',"
                    + "'" + card.getLastUpdatedDate() + "')");
            statement.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    @Override
    public void update(Long id, DoctorCard card) {
        try (Connection connect = ConnectionPG.connect(); Statement statement = connect.createStatement()) {
            String sql = "UPDATE doctor_card SET" +
                    " NAME = '"  + card.getName() + "'," +
                    " DATE_OF_BIRTH = '"  + card.getDateOfBirth() + "'," +
                    " SPECIALIZATION = '"  + card.getSpecialization() + "'," +
                    " WORK_EXPERIENCE = '"  + card.getWorkExperience() + "'," +
                    " DATE_OF_CREATE = '"  + card.getLastUpdatedDate() + "'" +
                    " WHERE id =" + id;
            System.out.println(sql);
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(Arrays.toString(e.getStackTrace()));
        }


    }

    @Override
    public void delete(Long id) {
        try (Connection connect = ConnectionPG.connect(); Statement statement = connect.createStatement()) {
           String sql = ("DELETE FROM doctor_card " +
                   "WHERE ID = "
                    + id + "");
           statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    @Override
    public Card getById(Long id) {
        return null;
    }

    @Override
    public List<Card> getAll(List<DoctorCard> cards) {
        return null;
    }


}
