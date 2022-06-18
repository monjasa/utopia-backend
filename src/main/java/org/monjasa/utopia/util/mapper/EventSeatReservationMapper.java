package org.monjasa.utopia.util.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.monjasa.utopia.domain.enums.EventSeatReservationStatus;
import org.monjasa.utopia.domain.event.EventSeatReservation;
import org.monjasa.utopia.dto.event.EventSeatReservationRequest;
import org.monjasa.utopia.util.helper.UuidHelper;

@Mapper
public interface EventSeatReservationMapper {

    @Mapping(target = "seat.id", source = "seatId")
    EventSeatReservation toEntity(EventSeatReservationRequest request);

    @AfterMapping
    default void afterToEntity(@MappingTarget EventSeatReservation seatReservation) {
        seatReservation.setStatus(EventSeatReservationStatus.UNVALIDATED);
        seatReservation.setUuid(UuidHelper.randomUuid());
    }
}
