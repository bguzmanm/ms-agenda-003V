package cl.duoc.agenda.repository;

import cl.duoc.agenda.model.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {
    List<Agenda> findByPatientId(Long patientId);
    List<Agenda> findByDoctorId(Long doctorId);
    List<Agenda> findByPatientIdAndDoctorId(Long patientId, Long doctorId);
}
