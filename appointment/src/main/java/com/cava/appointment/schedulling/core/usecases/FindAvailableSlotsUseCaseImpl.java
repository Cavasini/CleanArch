package com.cava.appointment.schedulling.core.usecases;

import com.cava.appointment.schedulling.core.gateway.AppointmentGateway;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class FindAvailableSlotsUseCaseImpl implements  FindAvailableSlotsUseCase{

    private final AppointmentGateway appointmentGateway;

    public FindAvailableSlotsUseCaseImpl(AppointmentGateway appointmentGateway){
        this.appointmentGateway = appointmentGateway;
    }

    @Override
    public List<LocalDateTime> execute(LocalDateTime startOfDay, LocalDateTime endOfDay, String intervalStep, UUID professionalId) {
        return appointmentGateway.findAvailableSlots(startOfDay, endOfDay, intervalStep, professionalId);
    }
}
