package org.monjasa.utopia.util.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.monjasa.utopia.domain.auditorium.AuditoriumSeat;
import org.monjasa.utopia.domain.event.EventSeatReservation;
import org.monjasa.utopia.dto.auditorium.AuditoriumSeatDto;
import org.monjasa.utopia.dto.auditorium.AuditoriumSeatReservationDto;

import java.util.Map;

@Mapper
public interface AuditoriumSeatMapper {

    @Mapping(target = "partName", source = "part.name")
    AuditoriumSeatDto toDto(AuditoriumSeat auditoriumSeat);

    @Mapping(target = "partName", source = "part.name")
    AuditoriumSeatReservationDto toReservationDto(AuditoriumSeat auditoriumSeat, @Context Map<Long, EventSeatReservation> seatReservationsBySeatId);

    @AfterMapping
    default void afterToReservationDto(
            @MappingTarget AuditoriumSeatReservationDto auditoriumSeatReservationDto,
            @Context Map<Long, EventSeatReservation> seatReservationsBySeatId) {
        boolean reserved = seatReservationsBySeatId.containsKey(auditoriumSeatReservationDto.getId());
        auditoriumSeatReservationDto.setReserved(reserved);
    }
}
