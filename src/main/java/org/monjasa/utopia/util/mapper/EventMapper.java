package org.monjasa.utopia.util.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.monjasa.utopia.domain.event.Event;
import org.monjasa.utopia.domain.performance.Performance;
import org.monjasa.utopia.dto.auditorium.AuditoriumReservationDto;
import org.monjasa.utopia.dto.event.EventConciseDto;
import org.monjasa.utopia.dto.event.EventDto;
import org.monjasa.utopia.dto.event.request.EventRequest;
import org.monjasa.utopia.dto.performance.PerformanceDto;

import java.time.LocalDateTime;

@Mapper(uses = {PerformanceMapper.class, AuditoriumMapper.class})
public interface EventMapper {

    @Mapping(target = "performance.id", source = "performanceId")
    @Mapping(target = "auditorium.id", source = "auditoriumId")
    Event toEntity(EventRequest request, @Context Performance performance);

    @AfterMapping
    default void afterToEntity(@MappingTarget Event event, @Context Performance performance) {
        LocalDateTime endedAt = event.getStartedAt().plus(performance.getDuration());
        event.setEndedAt(endedAt);
    }

    EventDto toDto(Event event, @Context PerformanceDto performanceDto, @Context AuditoriumReservationDto auditoriumDto);

    @AfterMapping
    default void afterToDto(
            @MappingTarget EventDto eventDto,
            @Context PerformanceDto performanceDto,
            @Context AuditoriumReservationDto auditoriumDto) {
        eventDto.setPerformance(performanceDto);
        eventDto.setAuditorium(auditoriumDto);
    }

    EventConciseDto toConciseDto(Event event);

}
