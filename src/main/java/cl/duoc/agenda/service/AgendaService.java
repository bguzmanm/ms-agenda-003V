package cl.duoc.agenda.service;

import cl.duoc.agenda.dto.AgendaResponseDto;
import cl.duoc.agenda.model.Agenda;

import java.util.List;

public interface AgendaService {
    List<AgendaResponseDto> findAll();
    AgendaResponseDto findById(Long id);
    List<AgendaResponseDto> findByPatientId(Long patientId);
    List<AgendaResponseDto> findByDoctorId(Long doctorId);
    List<AgendaResponseDto> findByPatientIdAndDoctorId(Long patientId, Long doctorId);
}
