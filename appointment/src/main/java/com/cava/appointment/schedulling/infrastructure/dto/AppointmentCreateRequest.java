package com.cava.appointment.schedulling.infrastructure.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record AppointmentCreateRequest(

        UUID professionalId,
        UUID clientId,
        LocalDateTime startAt,
        LocalDateTime endAt

){}
