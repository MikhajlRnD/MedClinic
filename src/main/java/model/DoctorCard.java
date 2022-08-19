package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import model.Card;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class DoctorCard extends Card {
    private Long id;
    private String name;
    private LocalDate dateOfBirth;
    private String specialization;
    private Integer workExperience;



}
