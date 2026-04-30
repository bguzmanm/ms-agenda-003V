package cl.duoc.agenda.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class PatientResponseDto {
    Long id;

    String name;
    String lastName;
    String email;
    String phone;
}
