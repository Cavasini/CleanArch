package com.cava.appointment.schedulling.core.event;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

public record AppointmentConfirmationEvent(
        EventMetadata metadata,

        // 🔹 Agendamento
        UUID appointmentId,
        LocalDateTime startAt,
        LocalDateTime endAt,

        // 🔹 Cliente
        UUID clientId,
        String clientName,
        String clientPhone,

        // 🔹 Profissional
        UUID professionalId,
        String professionalName,

        // 🔹 Confirmação
        LocalDateTime confirmationDeadline,
        String channel,
        String messageTemplate

) { }
