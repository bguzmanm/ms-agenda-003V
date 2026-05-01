package cl.duoc.agenda.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class DoctorResponseDto {
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    // private SpecialtyResponseDto specialty;
}
