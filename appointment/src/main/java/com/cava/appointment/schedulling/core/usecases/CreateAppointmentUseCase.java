package com.cava.appointment.schedulling.core.usecases;

import com.cava.appointment.schedulling.core.entities.Appointment;

public interface CreateAppointmentUseCase {

    Appointment execute(Appointment appointment);
}
