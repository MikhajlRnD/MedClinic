package model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import model.Card;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DoctorCard extends Card {
    private Long id;
    private String name;
    private LocalDate dateOfBirth;
    private String specialization;
    private Integer workExperience;





}
