package com.cava.appointment.schedulling.core.usecases;

import com.cava.appointment.schedulling.core.entities.Appointment;
import com.cava.appointment.schedulling.core.gateway.AppointmentGateway;

import java.util.UUID;

public class SearchAppointmentUseCaseImpl implements SearchAppointmentUseCase{

    private AppointmentGateway appointmentGateway;

    public SearchAppointmentUseCaseImpl(AppointmentGateway appointmentGateway){
        this.appointmentGateway = appointmentGateway;
    }

    @Override
    public Appointment execute(UUID id) {
        var appointment = appointmentGateway.searchAppointment(id);
        if(appointment == null){
            System.out.println("appointment not found");
        }
        return appointment;
    }
}
