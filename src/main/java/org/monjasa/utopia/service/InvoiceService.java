package org.monjasa.utopia.service;

import org.monjasa.utopia.domain.auditorium.AuditoriumSeat;
import org.monjasa.utopia.domain.event.EventReservation;
import org.monjasa.utopia.domain.invoice.Invoice;
import org.monjasa.utopia.domain.invoice.InvoicePayment;

import java.util.List;

public interface InvoiceService {

    void createByEventReservation(EventReservation eventReservation, List<AuditoriumSeat> auditoriumSeats);

    void createPaymentByInvoiceNumber(String invoiceNumber, InvoicePayment invoicePayment);

    Invoice getByEventReservationUuid(String eventReservationUuid);

}
