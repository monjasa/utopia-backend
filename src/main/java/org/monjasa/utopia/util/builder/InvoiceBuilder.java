package org.monjasa.utopia.util.builder;

import lombok.RequiredArgsConstructor;
import org.monjasa.utopia.domain.embeddable.InvoiceCharge;
import org.monjasa.utopia.domain.enums.InvoiceStatus;
import org.monjasa.utopia.domain.event.EventReservation;
import org.monjasa.utopia.domain.event.EventSeatReservation;
import org.monjasa.utopia.domain.invoice.Invoice;
import org.monjasa.utopia.util.helper.UuidHelper;
import org.monjasa.utopia.util.provider.InvoiceDescriptionProvider;
import org.monjasa.utopia.util.provider.LocaleProvider;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Currency;
import java.util.List;

@Component
@RequiredArgsConstructor
public class InvoiceBuilder {

    private final InvoiceDescriptionProvider invoiceDescriptionProvider;

    private final LocaleProvider localeProvider;

    public Invoice buildByEventReservation(EventReservation eventReservation) {
        Invoice invoice = new Invoice();
        invoice.setNumber(UuidHelper.randomUuid());
        invoice.setDescription(invoiceDescriptionProvider.provideDescriptionByEventReservation(eventReservation));
        invoice.setIssuedAt(Instant.now());
        invoice.setStatus(InvoiceStatus.ISSUED);
        invoice.setCharge(buildInvoiceCharge(eventReservation.getSeatReservations()));
        invoice.setEventReservation(eventReservation);
        return invoice;
    }

    private InvoiceCharge buildInvoiceCharge(List<EventSeatReservation> eventSeatReservations) {
        BigDecimal subtotal = getSubtotalByAuditoriumSeats(eventSeatReservations);
        InvoiceCharge invoiceCharge = new InvoiceCharge();
        invoiceCharge.setSubtotal(subtotal);
        invoiceCharge.setConcessionRate(BigDecimal.ZERO);
        invoiceCharge.setTotal(subtotal);
        invoiceCharge.setCurrency(Currency.getInstance(localeProvider.getDefaultLocale()));
        return invoiceCharge;
    }

    private BigDecimal getSubtotalByAuditoriumSeats(List<EventSeatReservation> eventSeatReservations) {
        return eventSeatReservations.stream()
                .map(EventSeatReservation::getSeat)
                .map(auditoriumSeat -> auditoriumSeat.getPricingPolicy().getPrice())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
