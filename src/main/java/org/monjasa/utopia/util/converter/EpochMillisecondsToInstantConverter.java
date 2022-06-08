package org.monjasa.utopia.util.converter;

import com.fasterxml.jackson.databind.util.StdConverter;

import java.time.Instant;

public class EpochMillisecondsToInstantConverter extends StdConverter<Long, Instant> {

    @Override
    public Instant convert(Long value) {
        return Instant.ofEpochMilli(value);
    }
}
