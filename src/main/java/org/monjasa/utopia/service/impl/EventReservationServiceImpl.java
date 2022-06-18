package org.monjasa.utopia.service.impl;

import lombok.RequiredArgsConstructor;
import org.monjasa.utopia.domain.enums.InvoiceStatus;
import org.monjasa.utopia.domain.event.EventReservation;
import org.monjasa.utopia.domain.invoice.Invoice;
import org.monjasa.utopia.dto.event.EventReservationDto;
import org.monjasa.utopia.dto.event.EventReservationIdentifierDto;
import org.monjasa.utopia.dto.event.EventReservationRequest;
import org.monjasa.utopia.repository.EventReservationRepository;
import org.monjasa.utopia.service.EventReservationService;
import org.monjasa.utopia.service.InvoiceService;
import org.monjasa.utopia.util.helper.UuidHelper;
import org.monjasa.utopia.util.mapper.EventReservationMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventReservationServiceImpl implements EventReservationService {

    private final InvoiceService invoiceService;

    private final EventReservationRepository eventReservationRepository;

    private final EventReservationMapper eventReservationMapper;

    @Override
    public EventReservationIdentifierDto create(EventReservationRequest request) {
        EventReservation eventReservation = eventReservationMapper.toEntity(request);
        eventReservation.setUuid(UuidHelper.randomUuid());
        eventReservation = eventReservationRepository.saveAndFlush(eventReservation);
        eventReservationRepository.clear();

        eventReservation = eventReservationRepository.findFetchingEventAndSeatReservationsById(eventReservation.getId()).orElseThrow();
        issueInvoice(eventReservation);

        return eventReservationMapper.toIdentifierDto(eventReservation);
    }

    @Override
    public EventReservationDto getByUuid(String uuid) {
        EventReservation eventReservation = eventReservationRepository.findFetchingEventAndSeatReservationsByUuid(uuid).orElseThrow();
        Invoice invoice = invoiceService.getByEventReservationUuid(uuid);

        EventReservationDto eventReservationDto = eventReservationMapper.toDto(eventReservation, invoice);
        if (invoice.getStatus() != InvoiceStatus.SETTLED) {
            eventReservationDto.getSeatReservations().clear();
        }

        return eventReservationDto;
    }

    private void issueInvoice(EventReservation eventReservation) {
        invoiceService.createByEventReservation(eventReservation);
    }
}
