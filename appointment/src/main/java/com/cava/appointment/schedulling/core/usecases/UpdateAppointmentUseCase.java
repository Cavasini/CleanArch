package com.cava.appointment.schedulling.core.usecases;

import com.cava.appointment.schedulling.core.entities.Appointment;

public interface UpdateAppointmentUseCase {

    Appointment execute(Appointment appointment);

}
