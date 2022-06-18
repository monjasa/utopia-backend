package org.monjasa.utopia.dto.event;

import lombok.Getter;
import lombok.Setter;
import org.monjasa.utopia.dto.invoice.InvoiceStateDto;

import java.util.List;

@Getter
@Setter
public class EventReservationDto {

    private Long id;

    private String uuid;

    private EventConciseDto event;

    private List<EventSeatReservationDto> seatReservations;

    private InvoiceStateDto invoice;

    private boolean deleted;

}
