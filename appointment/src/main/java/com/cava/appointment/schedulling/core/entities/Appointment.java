package com.cava.appointment.schedulling.core.entities;

import com.cava.appointment.schedulling.core.enums.AppointmentStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record Appointment (

    UUID id,
    UUID professionalId,
    UUID clientId,

    LocalDateTime startAt,
    LocalDateTime endAt,

    AppointmentStatus status,

    LocalDateTime createdAt,
    LocalDateTime updatedAt
){}
