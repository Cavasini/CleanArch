package com.cava.appointment.schedulling.core.usecases;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface FindAvailableSlotsUseCase {

    List<LocalDateTime> execute(LocalDateTime startOfDay, LocalDateTime endOfDay, String intervalStep, UUID professionalId);
}
