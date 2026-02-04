package com.cava.appointment.schedulling.infrastructure.gateway;

import com.cava.appointment.schedulling.core.entities.Appointment;
import com.cava.appointment.schedulling.core.gateway.AppointmentGateway;
import com.cava.appointment.schedulling.infrastructure.mapper.AppointmentEntityMapper;
import com.cava.appointment.schedulling.infrastructure.persistence.AppointmentEntity;
import com.cava.appointment.schedulling.infrastructure.persistence.AppointmentRepository;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Component
public class AppointmentRepositoryGateway implements AppointmentGateway{

    private final AppointmentRepository appointmentRepository;
    private final AppointmentEntityMapper appointmentEntityMapper;

    public AppointmentRepositoryGateway(AppointmentRepository appointmentRepository, AppointmentEntityMapper appointmentEntityMapper) {
        this.appointmentRepository = appointmentRepository;
        this.appointmentEntityMapper = appointmentEntityMapper;
    }

    @Override
    public Appointment createAppointment(Appointment appointment) {
        AppointmentEntity appointmentEntity = appointmentRepository.save(appointmentEntityMapper.toEntity(appointment));

        return appointmentEntityMapper.toDomain(appointmentEntity);
    }

    @Override
    public Appointment searchAppointment(UUID id) {
        return appointmentRepository.findById(id)
                .map(appointmentEntityMapper::toDomain)
                .orElse(null);
//
    }

    @Override
    public Appointment updateAppointment(Appointment appointment) {
        return null;
    }

    @Override
    public void deleteAppointment(UUID id) {

    }

    @Override
    public List<LocalDateTime> findAvailableSlots(LocalDateTime startOfDay, LocalDateTime endOfDay, String intervalStep, UUID professionalId) {
        return appointmentRepository.findAvailableSlots(startOfDay, endOfDay, intervalStep, professionalId);
    }
}
