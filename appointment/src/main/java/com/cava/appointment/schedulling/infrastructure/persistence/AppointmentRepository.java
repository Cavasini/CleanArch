package com.cava.appointment.schedulling.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface AppointmentRepository extends JpaRepository<AppointmentEntity, UUID> {

    @Query(value = """
        WITH horarios_possiveis AS (
            SELECT generate_series(
                CAST(:startOfDay AS TIMESTAMP), 
                CAST(:endOfDay AS TIMESTAMP), 
                CAST(:intervalStep AS INTERVAL)
            ) AS slot_inicio
        )
        SELECT CAST(hp.slot_inicio AS TIMESTAMP)
        FROM horarios_possiveis hp
        LEFT JOIN appointments a ON 
            a.professional_id = :professionalId
            AND a.status != 'CANCELADO'
            AND (
                a.start_at < (hp.slot_inicio + CAST(:intervalStep AS INTERVAL)) 
                AND a.end_at > hp.slot_inicio
            )
        WHERE a.id IS NULL
        ORDER BY hp.slot_inicio ASC
        """, nativeQuery = true)
    List<LocalDateTime> findAvailableSlots(
            @Param("startOfDay") LocalDateTime startOfDay,
            @Param("endOfDay") LocalDateTime endOfDay,
            @Param("intervalStep") String intervalStep, // Ex: "30 minutes"
            @Param("professionalId") UUID professionalId
    );
}
