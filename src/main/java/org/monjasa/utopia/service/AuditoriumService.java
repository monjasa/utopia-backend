package org.monjasa.utopia.service;

import org.monjasa.utopia.domain.event.EventSeatReservation;
import org.monjasa.utopia.dto.auditorium.AuditoriumItemDto;
import org.monjasa.utopia.dto.auditorium.AuditoriumReservationDto;
import org.monjasa.utopia.dto.auditorium.request.AuditoriumRequest;

import java.util.List;
import java.util.Map;

public interface AuditoriumService {

    void create(AuditoriumRequest request);

    List<AuditoriumItemDto> getAllItems();

    AuditoriumReservationDto getReservationDtoById(Long id, Map<Long, EventSeatReservation> seatReservationsBySeatId);

}
