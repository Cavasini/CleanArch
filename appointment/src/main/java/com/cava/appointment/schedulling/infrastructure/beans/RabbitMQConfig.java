package com.cava.appointment.schedulling.infrastructure.beans;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {


    public static final String EXCHANGE = "appointment.exchange";
    public static final String QUEUE = "appointment.confirmation.queue";
    public static final String ROUTING_KEY = "appointment.confirm";


    @Bean
    DirectExchange appointmentExchange(){
        return new DirectExchange(EXCHANGE, true, false);
    }

    @Bean
    Queue appointmentQueue() {
        return QueueBuilder
                .durable(QUEUE)
                .build();
    }

    @Bean
    Binding appointmentBinding() {
        return BindingBuilder
                .bind(appointmentQueue())
                .to(appointmentExchange())
                .with(ROUTING_KEY);
    }

    @Bean
    public MessageConverter converter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }


}
