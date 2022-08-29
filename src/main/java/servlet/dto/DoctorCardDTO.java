package servlet.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

public class DoctorCardDTO {
    private String name;
    private String dateOfBirth;
    private String specialization;
    private Integer workExperience;
}
