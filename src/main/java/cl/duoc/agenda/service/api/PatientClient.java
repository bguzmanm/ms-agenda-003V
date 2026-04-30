package cl.duoc.agenda.service.api;

import cl.duoc.agenda.dto.PatientResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "patient-service", url = "http://localhost:8080/api/v1/patients")
public interface PatientClient {

    @GetMapping("/{id}")
    PatientResponseDto findById(@PathVariable Long id);
}
