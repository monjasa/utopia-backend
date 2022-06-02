package org.monjasa.utopia.service;

import org.monjasa.utopia.domain.event.EventSeatReservation;

import java.util.List;

public interface EventSeatReservationService {

    List<EventSeatReservation> getAllPresentByEventId(Long eventId);

}
