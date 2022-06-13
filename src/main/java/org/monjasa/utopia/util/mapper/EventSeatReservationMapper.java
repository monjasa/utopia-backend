package org.monjasa.utopia.util.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.monjasa.utopia.domain.event.EventSeatReservation;
import org.monjasa.utopia.dto.event.EventSeatReservationRequest;

@Mapper
public interface EventSeatReservationMapper {

    @Mapping(target = "seat.id", source = "seatId")
    EventSeatReservation toEntity(EventSeatReservationRequest request);

}
