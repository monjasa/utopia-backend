package org.monjasa.utopia.service;

import org.monjasa.utopia.domain.event.EventReservation;
import org.monjasa.utopia.domain.invoice.Invoice;
import org.monjasa.utopia.domain.invoice.InvoicePayment;

public interface InvoiceService {

    void createByEventReservation(EventReservation eventReservation);

    void createPaymentByInvoiceNumber(String invoiceNumber, InvoicePayment invoicePayment);

    Invoice getByEventReservationUuid(String eventReservationUuid);

}
