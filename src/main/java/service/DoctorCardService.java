package service;

import model.Card;
import model.DoctorCard;

import java.util.List;
import java.util.UUID;

public interface DoctorCardService {

    void create(DoctorCard card);

    void update(UUID id, DoctorCard card);

    void delete(UUID id);

    Card getById(UUID id);

    List<DoctorCard> getAll();
}
