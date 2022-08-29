package model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DoctorCard extends Card {
    private UUID id;
    private String name;
    private LocalDate dateOfBirth;
    private String specialization;
    private Integer workExperience;


}
