package com.cava.appointment.schedulling.infrastructure.presentation;

import com.cava.appointment.schedulling.core.entities.Appointment;
import com.cava.appointment.schedulling.core.usecases.CreateAppointmentUseCase;
import com.cava.appointment.schedulling.core.usecases.SearchAppointmentUseCase;
import com.cava.appointment.schedulling.infrastructure.dto.AppointmentCreateRequest;
import com.cava.appointment.schedulling.infrastructure.mapper.AppointmentCreateMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
public class AppointmentController {

    private final CreateAppointmentUseCase createAppointmentUseCase;
    private final SearchAppointmentUseCase searchAppointmentUseCase;
    private final AppointmentCreateMapper appointmentCreateMapper;

    public AppointmentController(CreateAppointmentUseCase createAppointmentUseCase, SearchAppointmentUseCase searchAppointmentUseCase, AppointmentCreateMapper appointmentCreateMapper) {
        this.createAppointmentUseCase = createAppointmentUseCase;
        this.searchAppointmentUseCase = searchAppointmentUseCase;
        this.appointmentCreateMapper = appointmentCreateMapper;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@RequestBody AppointmentCreateRequest request){
        var created = createAppointmentUseCase.execute(appointmentCreateMapper.toEntity(request));

        Map<String, Object> response = new HashMap<>();
        response.put("Mensagem", "Agendamento criado com sucesso!");
        response.put("agendamento", created);
        return ResponseEntity.ok(response);
    }

}
