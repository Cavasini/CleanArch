package com.cava.appointment.schedulling.infrastructure.mapper;

import com.cava.appointment.schedulling.core.entities.Appointment;
import com.cava.appointment.schedulling.core.enums.AppointmentStatus;
import com.cava.appointment.schedulling.infrastructure.persistence.AppointmentEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class AppointmentEntityMapper {

    public AppointmentEntity toEntity(Appointment appointment){
        return AppointmentEntity.builder()
                .professionalId(appointment.professionalId())
                .clientId(appointment.clientId())
                .startAt(appointment.startAt())
                .endAt(appointment.endAt())
                .status(AppointmentStatus.SCHEDULED.name())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

    }

    public Appointment toDomain(AppointmentEntity appointmentEntity){
        return new Appointment(
                appointmentEntity.getId(),
                appointmentEntity.getProfessionalId(),
                appointmentEntity.getClientId(),
                appointmentEntity.getStartAt(),
                appointmentEntity.getEndAt(),
                AppointmentStatus.valueOf(appointmentEntity.getStatus()),
                appointmentEntity.getCreatedAt(),
                appointmentEntity.getUpdatedAt()
        );
    }

}
