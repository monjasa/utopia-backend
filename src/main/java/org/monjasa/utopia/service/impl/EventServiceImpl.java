package org.monjasa.utopia.service.impl;

import lombok.RequiredArgsConstructor;
import org.monjasa.utopia.domain.event.Event;
import org.monjasa.utopia.domain.event.EventSeatReservation;
import org.monjasa.utopia.domain.performance.Performance;
import org.monjasa.utopia.dto.event.EventConciseDto;
import org.monjasa.utopia.dto.event.EventDto;
import org.monjasa.utopia.dto.event.request.EventRequest;
import org.monjasa.utopia.repository.EventRepository;
import org.monjasa.utopia.service.AuditoriumService;
import org.monjasa.utopia.service.EventSeatReservationService;
import org.monjasa.utopia.service.EventService;
import org.monjasa.utopia.service.PerformanceService;
import org.monjasa.utopia.util.mapper.EventMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventSeatReservationService eventSeatReservationService;

    private final AuditoriumService auditoriumService;

    private final PerformanceService performanceService;

    private final EventRepository eventRepository;

    private final EventMapper eventMapper;

    @Override
    public void create(EventRequest request) {
        Performance performance = performanceService.getById(request.getPerformanceId());
        Event event = eventMapper.toEntity(request, performance);
        eventRepository.save(event);
    }

    @Override
    public EventDto getDtoById(Long id) {
        Event event = eventRepository.findById(id).orElseThrow();

        Map<Long, EventSeatReservation> seatReservationsBySeatId = getSeatReservationsBySeatId(event);
        return eventMapper.toDto(
                event,
                performanceService.getDtoById(event.getPerformance().getId()),
                auditoriumService.getReservationDtoById(event.getAuditorium().getId(), seatReservationsBySeatId)
        );
    }

    @Override
    public List<EventConciseDto> getAllConcise() {
        List<Event> events = eventRepository.findAllByOrderByStartedAt();
        return events.stream()
                .map(eventMapper::toConciseDto)
                .toList();
    }

    private Map<Long, EventSeatReservation> getSeatReservationsBySeatId(Event event) {
        return eventSeatReservationService.getAllPresentByEventId(event.getId()).stream()
                .collect(Collectors.toMap(
                        eventSeatReservation -> eventSeatReservation.getSeat().getId(),
                        Function.identity()
                ));
    }
}
