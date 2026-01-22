package com.cava.appointment.schedulling.core.usecases;

import java.util.UUID;

public interface DeleteAppointmentUseCase {

    void execute(UUID id);
}
