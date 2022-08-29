package service;

import configuration.ConnectionPG;
import model.Card;
import model.DoctorCard;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class DoctorCardServicePostgres implements DoctorCardService {
    private final String CREATE_QUERY = "INSERT INTO doctor_card " +
            "(ID, NAME, DATE_OF_BIRTH, SPECIALIZATION, WORK_EXPERIENCE, DATE_OF_CREATE)"
            + " VALUES (?, ?, ?, ?, ?, ?)";
    private final String UPDATE_QUERY = "UPDATE doctor_card SET " +
            "NAME = ?, DATE_OF_BIRTH = ?, " +
            "SPECIALIZATION = ?, WORK_EXPERIENCE = ?, " +
            "DATE_OF_CREATE =? WHERE ID = ?";
    private final String DELETE_QUERY = "DELETE FROM doctor_card " +
            "WHERE ID = ?";

    private final String GET_BY_ID_QUERY = "SELECT * FROM doctor_card WHERE ID = ?";
    private final String GET_ALL_QUERY = "SELECT * FROM doctor_card";


    @Override
    public void create(DoctorCard card) {
        try (Connection connect = ConnectionPG.connect();
             PreparedStatement statement = connect.prepareStatement(CREATE_QUERY)) {
            statement.setObject(1, UUID.randomUUID());
            statement.setString(2, card.getName());
            statement.setDate(3, Date.valueOf(card.getDateOfBirth()));
            statement.setString(4, card.getSpecialization());
            statement.setInt(5, card.getWorkExperience());
            statement.setTimestamp(6, Timestamp.valueOf(LocalDateTime.now()));
            statement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    @Override
    public void update(UUID id, DoctorCard card) {
        try (Connection connect = ConnectionPG.connect();
             PreparedStatement statement = connect.prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, card.getName());
            statement.setDate(2, Date.valueOf(card.getDateOfBirth()));
            statement.setString(3, card.getSpecialization());
            statement.setInt(4, card.getWorkExperience());
            statement.setTimestamp(5, Timestamp.valueOf(card.getLastUpdatedDate()));
            statement.setString(6, String.valueOf(id));
            statement.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    @Override
    public void delete(UUID id) {
        try (Connection connect = ConnectionPG.connect();
             PreparedStatement statement = connect.prepareStatement(DELETE_QUERY)) {
            statement.setString(1, String.valueOf(id));
            statement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(Arrays.toString(e.getStackTrace()));
        }

    }

    @Override
    public Card getById(UUID id) {
        DoctorCard doctorCard = new DoctorCard();
        try (Connection connect = ConnectionPG.connect();
             PreparedStatement statement = connect.prepareStatement(GET_BY_ID_QUERY)) {
            statement.setString(1, String.valueOf(id));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                doctorCard.setId(UUID.fromString(resultSet.getString("ID")));
                doctorCard.setName(resultSet.getString("NAME"));
                doctorCard.setDateOfBirth(resultSet.getDate("DATE_OF_BIRTH").toLocalDate());
                doctorCard.setSpecialization(resultSet.getString("SPECIALIZATION"));
                doctorCard.setWorkExperience(resultSet.getInt("WORK_EXPERIENCE"));
                doctorCard.setLastUpdatedDate(resultSet.getTimestamp("DATE_OF_CREATE").toLocalDateTime());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        return doctorCard;
    }

    @Override
    public List<DoctorCard> getAll() {
        List<DoctorCard> cardList = new ArrayList<>();
        try (Connection connect = ConnectionPG.connect();
             PreparedStatement statement = connect.prepareStatement(GET_ALL_QUERY)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                DoctorCard doctorCard = new DoctorCard();
                doctorCard.setId(UUID.fromString(resultSet.getString("ID")));
                doctorCard.setName(resultSet.getString("NAME"));
                doctorCard.setDateOfBirth(resultSet.getDate("DATE_OF_BIRTH").toLocalDate());
                doctorCard.setSpecialization(resultSet.getString("SPECIALIZATION"));
                doctorCard.setWorkExperience(resultSet.getInt("WORK_EXPERIENCE"));
                doctorCard.setLastUpdatedDate(resultSet.getTimestamp("DATE_OF_CREATE").toLocalDateTime());
                cardList.add(doctorCard);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        return cardList;
    }
}