package com.cava.appointment.schedulling.core.gateway;

import com.cava.appointment.schedulling.core.entities.Appointment;

import java.util.UUID;

public interface AppointmentGateway {

    Appointment createAppointment(Appointment appointment);
    Appointment searchAppointment(UUID id);
    Appointment updateAppointment(Appointment appointment);
    void deleteAppointment(UUID id);

}
