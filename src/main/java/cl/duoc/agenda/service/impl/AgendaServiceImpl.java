package cl.duoc.agenda.service.impl;

import cl.duoc.agenda.dto.AgendaResponseDto;
import cl.duoc.agenda.dto.DoctorResponseDto;
import cl.duoc.agenda.dto.PatientResponseDto;
import cl.duoc.agenda.model.Agenda;
import cl.duoc.agenda.repository.AgendaRepository;
import cl.duoc.agenda.service.AgendaService;
import cl.duoc.agenda.service.api.DoctorClient;
import cl.duoc.agenda.service.api.PatientClient;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class AgendaServiceImpl implements AgendaService {

    private final AgendaRepository repository;
    private final PatientClient patient;
    private final DoctorClient doctor;

    AgendaResponseDto toDto(Agenda entity) {
        return new AgendaResponseDto(
                entity.getId(),
                entity.getPatientId(),
                entity.getDoctorId(),
                entity.getDate()

        );
    }

    Agenda toEntity(AgendaResponseDto dto) {
        return new Agenda(dto.getId(),
                dto.getPatientId(),
                dto.getDoctorId(),
                dto.getDate());
    }

    public AgendaServiceImpl(AgendaRepository repository, PatientClient patient, DoctorClient doctor) {
        this.repository = repository;
        this.patient = patient;
        this.doctor = doctor;
    }

    @Override
    public List<AgendaResponseDto> findAll() {
        return repository.findAll().stream().map(this::toDto).toList();
    }

    @Override
    public AgendaResponseDto findById(Long id) {
        return repository.findById(id).map(this::toDto).orElse(null);
    }

    @Override
    public List<AgendaResponseDto> findByPatientId(Long patientId) {
        // validar que el id de paciente exista en el servicio de paciente.
        try {
            PatientResponseDto p = patient.findById(patientId);
            if (p == null) {
                log.warn("Patient with id {} not found", patientId);
                return null;
            }
            return repository.findByPatientId(patientId).stream().map(this::toDto).toList();
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public List<AgendaResponseDto> findByDoctorId(Long doctorId) {
        // validar que el id de doctor exista en el servicio de doctores.
        DoctorResponseDto d = doctor.findById(doctorId);
        if (d == null) {
            log.warn("Doctor with id {} not found", doctorId);
            return null;
        }

        return repository.findByDoctorId(doctorId).stream().map(this::toDto).toList();
    }

    @Override
    public List<AgendaResponseDto> findByPatientIdAndDoctorId(Long patientId, Long doctorId) {
        return List.of();
    }
}
