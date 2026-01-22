package com.cava.appointment.schedulling.core.usecases;

import com.cava.appointment.schedulling.core.entities.Appointment;
import com.cava.appointment.schedulling.core.gateway.AppointmentGateway;

public class UpdateAppointmentUseCaseImpl implements UpdateAppointmentUseCase{

    private AppointmentGateway appointmentGateway;

    public UpdateAppointmentUseCaseImpl(AppointmentGateway appointmentGateway){
        this.appointmentGateway = appointmentGateway;
    }

    @Override
    public Appointment execute(Appointment appointment) {
        // regra de negocio para validar se agendamento existe

        appointmentGateway.updateAppointment(appointment);
        return appointment;
    }
}
