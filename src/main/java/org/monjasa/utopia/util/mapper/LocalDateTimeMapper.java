package org.monjasa.utopia.util.mapper;

import lombok.RequiredArgsConstructor;
import org.monjasa.utopia.util.provider.TimeZoneProvider;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class LocalDateTimeMapper {

    private final TimeZoneProvider timeZoneProvider;

    public Instant toInstant(LocalDateTime localDateTime) {
        return localDateTime.atZone(timeZoneProvider.getDefaultTimeZone()).toInstant();
    }

    public LocalDateTime toLocalDateTime(Instant instant) {
        return LocalDateTime.ofInstant(instant, timeZoneProvider.getDefaultTimeZone());
    }
}
