package cl.duoc.agenda.controller;

import cl.duoc.agenda.dto.AgendaResponseDto;
import cl.duoc.agenda.dto.PatientResponseDto;
import cl.duoc.agenda.service.AgendaService;
import lombok.RequiredArgsConstructor;
import org.hibernate.query.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/agendas")
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
    public ResponseEntity<List<AgendaResponseDto>> findByPatientId(@PathVariable Long patientId) {
        return ResponseEntity.ok(service.findByPatientId(patientId));
    }
}
