package org.monjasa.utopia.service.impl;

import lombok.RequiredArgsConstructor;
import org.monjasa.utopia.domain.event.EventSeatReservation;
import org.monjasa.utopia.repository.EventSeatReservationRepository;
import org.monjasa.utopia.service.EventSeatReservationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventSeatReservationServiceImpl implements EventSeatReservationService {

    private final EventSeatReservationRepository eventSeatReservationRepository;

    @Override
    public List<EventSeatReservation> getAllPresentByEventId(Long eventId) {
        return eventSeatReservationRepository.findAllPresentByEventId(eventId);
    }
}
