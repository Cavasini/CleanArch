package com.cava.appointment.schedulling.infrastructure.presentation;

import com.cava.appointment.schedulling.core.entities.Appointment;
import com.cava.appointment.schedulling.core.usecases.CreateAppointmentConfirmationEventUseCase;
import com.cava.appointment.schedulling.core.usecases.CreateAppointmentUseCase;
import com.cava.appointment.schedulling.core.usecases.FindAvailableSlotsUseCase;
import com.cava.appointment.schedulling.core.usecases.SearchAppointmentUseCase;
import com.cava.appointment.schedulling.infrastructure.dto.AppointmentCreateRequest;
import com.cava.appointment.schedulling.infrastructure.dto.TesteDTO;
import com.cava.appointment.schedulling.infrastructure.mapper.AppointmentCreateMapper;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

@RestController
public class AppointmentController {

    private final CreateAppointmentUseCase createAppointmentUseCase;
    private final SearchAppointmentUseCase searchAppointmentUseCase;
    private final AppointmentCreateMapper appointmentCreateMapper;
    private final CreateAppointmentConfirmationEventUseCase createAppointmentConfirmationEventUseCase;
    private final FindAvailableSlotsUseCase findAvailableSlotsUseCase;

    public AppointmentController(CreateAppointmentUseCase createAppointmentUseCase, SearchAppointmentUseCase searchAppointmentUseCase, AppointmentCreateMapper appointmentCreateMapper, CreateAppointmentConfirmationEventUseCase createAppointmentConfirmationEventUseCase, FindAvailableSlotsUseCase findAvailableSlotsUseCase) {
        this.createAppointmentUseCase = createAppointmentUseCase;
        this.searchAppointmentUseCase = searchAppointmentUseCase;
        this.appointmentCreateMapper = appointmentCreateMapper;
        this.createAppointmentConfirmationEventUseCase = createAppointmentConfirmationEventUseCase;
        this.findAvailableSlotsUseCase = findAvailableSlotsUseCase;
    }

    @PostMapping()
    public ResponseEntity<Map<String, Object>> create(@RequestBody AppointmentCreateRequest request){
        var created = createAppointmentUseCase.execute(appointmentCreateMapper.toEntity(request));

        Map<String, Object> response = new HashMap<>();
        response.put("Mensagem", "Agendamento criado com sucesso!");
        response.put("agendamento", created);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/teste")
    public List<?> teste(){
//        createAppointmentConfirmationEventUseCase.execute();
        LocalDate date = LocalDate.of(2025, 2, 8);
        LocalDateTime startOfDay = date.atTime(8, 0);
        LocalDateTime endOfDay = date.atTime(16, 30);
        String intervalStep = "30 minutes";
        return findAvailableSlotsUseCase.execute(startOfDay, endOfDay, intervalStep, UUID.fromString("3fa85f64-5717-4562-b3fc-2c963f66afa6"));
    }

    @GetMapping
    public void foi(@RequestBody TesteDTO request){
        System.out.println("foi");
        System.out.println(request.message());
        System.out.println(request.phone());
    }

    @GetMapping("nao")
    public void naofoi(){
        System.out.println("naofoi");
    }

}
