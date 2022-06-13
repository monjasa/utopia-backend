package org.monjasa.utopia.util.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.monjasa.utopia.domain.auditorium.Auditorium;
import org.monjasa.utopia.domain.auditorium.AuditoriumSeat;
import org.monjasa.utopia.domain.auditorium.AuditoriumSeatPricingPolicy;
import org.monjasa.utopia.domain.event.EventSeatReservation;
import org.monjasa.utopia.dto.auditorium.AuditoriumItemDto;
import org.monjasa.utopia.dto.auditorium.AuditoriumReservationDto;
import org.monjasa.utopia.dto.auditorium.AuditoriumSeatReservationDto;
import org.monjasa.utopia.dto.auditorium.request.AuditoriumRequest;
import org.monjasa.utopia.dto.auditorium.request.AuditoriumSeatRequest;

import java.util.Map;

@Mapper(collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
public interface AuditoriumMapper {

    @Mapping(target = "seatPricingPolicies", ignore = true)
    Auditorium toEntity(AuditoriumRequest request, @Context Map<Integer, AuditoriumSeatPricingPolicy> seatPricingPolicies);

    @AfterMapping
    default void afterToEntity(
            @MappingTarget AuditoriumSeat auditoriumSeat,
            AuditoriumSeatRequest request,
            @Context Map<Integer, AuditoriumSeatPricingPolicy> seatPricingPolicies) {
        auditoriumSeat.setPricingPolicy(seatPricingPolicies.get(request.getPricingPolicyDisplayPosition()));
    }

    @AfterMapping
    default void afterToEntity(
            @MappingTarget Auditorium auditorium,
            @Context Map<Integer, AuditoriumSeatPricingPolicy> seatPricingPolicies) {
        seatPricingPolicies.values().forEach(auditorium::addAuditoriumSeatPricingPolicy);
    }

    AuditoriumItemDto toItemDto(Auditorium auditorium);

    AuditoriumReservationDto toReservationDto(Auditorium auditorium, @Context Map<Long, EventSeatReservation> seatReservationsBySeatId);

    @AfterMapping
    default void afterToReservationDto(
            @MappingTarget AuditoriumSeatReservationDto auditoriumSeatReservationDto,
            AuditoriumSeat auditoriumSeat,
            @Context Map<Long, EventSeatReservation> seatReservationsBySeatId) {
        auditoriumSeatReservationDto.setPartName(auditoriumSeat.getPart().getName());
        boolean reserved = seatReservationsBySeatId.containsKey(auditoriumSeatReservationDto.getId());
        auditoriumSeatReservationDto.setReserved(reserved);
    }
}
