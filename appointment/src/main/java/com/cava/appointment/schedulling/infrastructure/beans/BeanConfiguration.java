package com.cava.appointment.schedulling.infrastructure.beans;

import com.cava.appointment.schedulling.core.gateway.AppointmentEventGateway;
import com.cava.appointment.schedulling.core.gateway.AppointmentGateway;
import com.cava.appointment.schedulling.core.usecases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CreateAppointmentUseCase createAppointmentUseCase(AppointmentGateway appointmentGateway){
        return new CreateAppointmentUseCaseImpl(appointmentGateway);
    }

    @Bean
    public SearchAppointmentUseCase searchAppointmentUseCase(AppointmentGateway appointmentGateway){
        return new SearchAppointmentUseCaseImpl(appointmentGateway);
    }

    @Bean
    public CreateAppointmentConfirmationEventUseCase createAppointmentConfirmationEventUseCase(AppointmentEventGateway appointmentEventGateway){
        return new CreateAppointmentConfirmationEventUseCaseImpl(appointmentEventGateway);
    }

    @Bean
    public FindAvailableSlotsUseCase findAvailableSlotsUseCase(AppointmentGateway appointmentGateway){
        return new FindAvailableSlotsUseCaseImpl(appointmentGateway);
    }


}
