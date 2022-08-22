package service;

import model.Card;
import model.DoctorCard;

import java.util.List;

public interface DoctorCardService {
    void createTabe();
    void create (DoctorCard card);
    void update (Long id, DoctorCard card);
    void delete (Long id);
    Card getById (Long id);
    List<Card> getAll (List<DoctorCard> cards);
}
