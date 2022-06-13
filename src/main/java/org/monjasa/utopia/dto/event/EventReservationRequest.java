package org.monjasa.utopia.dto.event;

import lombok.Getter;
import lombok.Setter;
import org.monjasa.utopia.domain.embeddable.EventVisitorDetails;

import java.util.List;

@Getter
@Setter
public class EventReservationRequest {

    private Long eventId;

    private EventVisitorDetails visitorDetails;

    private List<EventSeatReservationRequest> seatReservations;

}
