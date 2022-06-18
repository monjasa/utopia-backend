package org.monjasa.utopia.dto.event;

import lombok.Getter;
import lombok.Setter;
import org.monjasa.utopia.domain.enums.EventSeatReservationStatus;
import org.monjasa.utopia.dto.auditorium.AuditoriumSeatDto;

@Getter
@Setter
public class EventSeatReservationDto {

    private Long id;

    private String uuid;

    private EventSeatReservationStatus status;

    private AuditoriumSeatDto seat;

}
