package com.cava.appointment.schedulling.core.usecases;

import com.cava.appointment.schedulling.core.entities.Appointment;

import java.util.UUID;

public interface SearchAppointmentUseCase {

    Appointment execute(UUID id);
}
