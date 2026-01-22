package com.cava.appointment.schedulling.core.usecases;

import com.cava.appointment.schedulling.core.entities.Appointment;
import com.cava.appointment.schedulling.core.gateway.AppointmentGateway;

public class CreateAppointmentUseCaseImpl implements CreateAppointmentUseCase{

    private final AppointmentGateway appointmentGateway;

    public CreateAppointmentUseCaseImpl(AppointmentGateway appointmentGateway){
        this.appointmentGateway = appointmentGateway;
    }

    @Override
    public Appointment execute(Appointment appointment) {

        System.out.println("estarei criando o agendamento");
        appointmentGateway.createAppointment(appointment);
        return appointment;
    }
}
