package com.cava.appointment.schedulling.infrastructure.mapper;

import com.cava.appointment.schedulling.core.entities.Appointment;
import com.cava.appointment.schedulling.core.enums.AppointmentStatus;
import com.cava.appointment.schedulling.infrastructure.dto.AppointmentCreateRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class AppointmentCreateMapper {

    public AppointmentCreateRequest toDto(Appointment appointment){
        return new AppointmentCreateRequest(
                appointment.professionalId(),
                appointment.clientId(),
                appointment.startAt(),
                appointment.endAt()
        );
    }

    public Appointment toEntity(AppointmentCreateRequest appointmentCreateRequest){
        return new Appointment(
                null,
                appointmentCreateRequest.professionalId(),
                appointmentCreateRequest.clientId(),
                appointmentCreateRequest.startAt(),
                appointmentCreateRequest.endAt(),
                AppointmentStatus.SCHEDULED,
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }

}
