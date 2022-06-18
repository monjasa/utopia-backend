package org.monjasa.utopia.service;

import org.monjasa.utopia.dto.event.EventReservationDto;
import org.monjasa.utopia.dto.event.EventReservationIdentifierDto;
import org.monjasa.utopia.dto.event.EventReservationRequest;

public interface EventReservationService {

    EventReservationIdentifierDto create(EventReservationRequest request);

    EventReservationDto getByUuid(String uuid);

}
