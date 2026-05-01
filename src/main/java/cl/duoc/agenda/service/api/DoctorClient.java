package cl.duoc.agenda.service.api;

import cl.duoc.agenda.dto.DoctorResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "doctor-service", url = "http://localhost:8081/api/v1/doctors")
public interface DoctorClient {

    @GetMapping("/{id}")
    DoctorResponseDto findById(@PathVariable Long id);
}
