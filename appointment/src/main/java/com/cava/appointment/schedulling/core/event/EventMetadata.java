package com.cava.appointment.schedulling.core.event;

import java.time.LocalDateTime;
import java.util.UUID;

public record EventMetadata(
        UUID eventId,
        String type,
        String version,
        LocalDateTime occurredAt
) {

    public static EventMetadata now(String type, String version){
        return new EventMetadata(
                UUID.randomUUID(),
                type,
                version,
                LocalDateTime.now()
        );
    }
}
