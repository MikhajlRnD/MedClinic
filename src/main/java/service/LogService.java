package service;

import model.Card;
import model.DoctorCard;

import java.time.LocalDateTime;

public interface LogService {

    void creedLog (String operation, Card card, LocalDateTime time);


}
