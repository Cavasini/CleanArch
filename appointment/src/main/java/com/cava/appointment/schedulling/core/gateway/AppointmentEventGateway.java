package com.cava.appointment.schedulling.core.gateway;

import com.cava.appointment.schedulling.core.event.AppointmentConfirmationEvent;

public interface AppointmentEventGateway {

    void createAppointmentEvent(AppointmentConfirmationEvent confirmationEvent);
}
