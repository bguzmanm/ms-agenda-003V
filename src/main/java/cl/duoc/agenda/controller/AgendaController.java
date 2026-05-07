package cl.duoc.agenda.controller;

import cl.duoc.agenda.dto.AgendaResponseDto;
import cl.duoc.agenda.service.AgendaService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/agendas")
@Log4j2
public class AgendaController {

    private final AgendaService service;

    public AgendaController(AgendaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<AgendaResponseDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/by-patient/{patientId}")
    public ResponseEntity<List<AgendaResponseDto>> findByPatientId(@PathVariable Long patientId) throws Exception {

        try {
            List<AgendaResponseDto> agendaResponseDto = service.findByPatientId(patientId);
            return ResponseEntity.ok(service.findByPatientId(patientId));

        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/by-doctor/{doctorId}")
    public ResponseEntity<List<AgendaResponseDto>> findByDoctorId(@PathVariable Long doctorId) {
        return ResponseEntity.ok(service.findByDoctorId(doctorId));
    }
}
