package com.cava.appointment.schedulling.infrastructure.beans;

import com.cava.appointment.schedulling.core.gateway.AppointmentGateway;
import com.cava.appointment.schedulling.core.usecases.CreateAppointmentUseCase;
import com.cava.appointment.schedulling.core.usecases.CreateAppointmentUseCaseImpl;
import com.cava.appointment.schedulling.core.usecases.SearchAppointmentUseCase;
import com.cava.appointment.schedulling.core.usecases.SearchAppointmentUseCaseImpl;
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


}
