package servlet.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data

public class DoctorCardDTO {
    private String name;
    private LocalDate dateOfBirth;
    private String specialization;
    private Integer workExperience;
}
