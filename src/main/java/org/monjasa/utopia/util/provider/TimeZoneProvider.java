package org.monjasa.utopia.util.provider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.ZoneId;

@Component
public class TimeZoneProvider {

    @Value("${app.time-zone.time-zone-id}")
    private String timeZoneId;

    public ZoneId getDefaultTimeZone() {
        return ZoneId.of(timeZoneId);
    }
}
