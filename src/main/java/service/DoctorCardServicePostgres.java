package service;

import configuration.ConnectionPG;
import configuration.TableCreate;
import model.Card;
import model.DoctorCard;
import service.DoctorCardService;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DoctorCardServicePostgres implements DoctorCardService {
    @Override
    public void create(DoctorCard card) {

    }

    @Override
    public void update(Long id, DoctorCard card) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Card getById(Long id) {
        return null;
    }

    @Override
    public List<Card> getAll(List<DoctorCard> cards) {
        return null;
    }

    @Override
    public void createTabe() {
        Connection connect = ConnectionPG.connect();
        try {
            Statement stmt = connect.createStatement();
            stmt.executeUpdate(TableCreate.SQL_CREATE);
            stmt.close();
            connect.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }
}
