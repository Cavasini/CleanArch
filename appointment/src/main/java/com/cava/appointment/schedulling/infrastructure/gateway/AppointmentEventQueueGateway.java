package com.cava.appointment.schedulling.infrastructure.gateway;

import com.cava.appointment.schedulling.core.event.AppointmentConfirmationEvent;
import com.cava.appointment.schedulling.core.gateway.AppointmentEventGateway;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class AppointmentEventQueueGateway implements AppointmentEventGateway {

    private final RabbitTemplate rabbitTemplate;

    public AppointmentEventQueueGateway(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void createAppointmentEvent(AppointmentConfirmationEvent confirmationEvent) {

        rabbitTemplate.convertAndSend(
                "appointment.exchange",
                "appointment.confirm",
                confirmationEvent
        );

    }
}
