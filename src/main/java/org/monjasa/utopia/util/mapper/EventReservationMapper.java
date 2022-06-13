package org.monjasa.utopia.util.mapper;

import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.monjasa.utopia.domain.event.EventReservation;
import org.monjasa.utopia.dto.event.EventReservationIdentifierDto;
import org.monjasa.utopia.dto.event.EventReservationRequest;

@Mapper(collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
        uses = EventSeatReservationMapper.class)
public interface EventReservationMapper {

    @Mapping(target = "event.id", source = "eventId")
    EventReservation toEntity(EventReservationRequest request);

    EventReservationIdentifierDto toIdentifierDto(EventReservation eventReservation);

}
