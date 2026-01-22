package com.cava.appointment.schedulling.core.usecases;

import com.cava.appointment.schedulling.core.gateway.AppointmentGateway;

import java.util.UUID;

public class DeleteAppointmentUseCaseImpl implements DeleteAppointmentUseCase{

    private AppointmentGateway appointmentGateway;

    public DeleteAppointmentUseCaseImpl(AppointmentGateway appointmentGateway){
        this.appointmentGateway = appointmentGateway;
    }

    @Override
    public void execute(UUID id) {
        var appointmentExists = appointmentGateway.searchAppointment(id);
        if(appointmentExists == null){
            System.out.println("agendamento nao existe");
//            throw new error
        }
        appointmentGateway.deleteAppointment(id);
    }
}
