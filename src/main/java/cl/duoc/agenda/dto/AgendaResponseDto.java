package cl.duoc.agenda.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class AgendaResponseDto {
    private Long id;
    private Long patientId;
    private Long doctorId;
    private String date;
}
