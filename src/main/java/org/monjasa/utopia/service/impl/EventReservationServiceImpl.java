package org.monjasa.utopia.service.impl;

import lombok.RequiredArgsConstructor;
import org.monjasa.utopia.domain.auditorium.AuditoriumSeat;
import org.monjasa.utopia.domain.event.EventReservation;
import org.monjasa.utopia.dto.event.EventReservationIdentifierDto;
import org.monjasa.utopia.dto.event.EventReservationRequest;
import org.monjasa.utopia.dto.event.EventSeatReservationRequest;
import org.monjasa.utopia.repository.EventReservationRepository;
import org.monjasa.utopia.service.AuditoriumSeatService;
import org.monjasa.utopia.service.EventReservationService;
import org.monjasa.utopia.service.InvoiceService;
import org.monjasa.utopia.util.helper.UuidHelper;
import org.monjasa.utopia.util.mapper.EventReservationMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventReservationServiceImpl implements EventReservationService {

    private final AuditoriumSeatService auditoriumSeatService;

    private final InvoiceService invoiceService;

    private final EventReservationRepository eventReservationRepository;

    private final EventReservationMapper eventReservationMapper;

    @Override
    public EventReservationIdentifierDto create(EventReservationRequest request) {
        List<AuditoriumSeat> auditoriumSeats = getAuditoriumSeats(request);

        EventReservation eventReservation = eventReservationMapper.toEntity(request);
        eventReservation.setUuid(UuidHelper.randomUuid());
        eventReservation = eventReservationRepository.save(eventReservation);

        issueInvoice(eventReservation, auditoriumSeats);

        return eventReservationMapper.toIdentifierDto(eventReservation);
    }

    private void issueInvoice(EventReservation eventReservation, List<AuditoriumSeat> auditoriumSeats) {
        invoiceService.createByEventReservation(eventReservation, auditoriumSeats);
    }

    private List<AuditoriumSeat> getAuditoriumSeats(EventReservationRequest request) {
        List<Long> auditoriumSeatIds = request.getSeatReservations().stream()
                .map(EventSeatReservationRequest::getSeatId)
                .toList();
        return auditoriumSeatService.getAllByIds(auditoriumSeatIds);
    }
}
