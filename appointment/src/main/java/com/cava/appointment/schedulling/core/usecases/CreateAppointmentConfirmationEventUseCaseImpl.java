package com.cava.appointment.schedulling.core.usecases;

import com.cava.appointment.schedulling.core.entities.Appointment;
import com.cava.appointment.schedulling.core.event.AppointmentConfirmationEvent;
import com.cava.appointment.schedulling.core.event.EventMetadata;
import com.cava.appointment.schedulling.core.gateway.AppointmentEventGateway;

import java.time.LocalDateTime;
import java.util.UUID;

public class CreateAppointmentConfirmationEventUseCaseImpl implements CreateAppointmentConfirmationEventUseCase {

    private final AppointmentEventGateway appointmentEventGateway;

    public CreateAppointmentConfirmationEventUseCaseImpl(AppointmentEventGateway appointmentEventGateway){
        this.appointmentEventGateway = appointmentEventGateway;
    }

    @Override
    public void execute() {
        EventMetadata eventMetadata = EventMetadata.now("Whatsapp","v1");
        AppointmentConfirmationEvent event = new AppointmentConfirmationEvent(
                eventMetadata,

                // 🔹 Agendamento
                UUID.randomUUID(),
                LocalDateTime.now(),
                LocalDateTime.now(),

                // 🔹 Cliente
                UUID.randomUUID(),
                "clientName",
                "25187365287123",

                // 🔹 Profissional
                UUID.randomUUID(),
                "ProfessionalName",

                // 🔹 Confirmação
                LocalDateTime.now(),
                "sei la",
                "messagetemplate"
        );

        appointmentEventGateway.createAppointmentEvent(event);
    }
}
