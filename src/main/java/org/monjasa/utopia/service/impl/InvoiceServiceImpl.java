package org.monjasa.utopia.service.impl;

import lombok.RequiredArgsConstructor;
import org.monjasa.utopia.domain.auditorium.AuditoriumSeat;
import org.monjasa.utopia.domain.enums.InvoiceStatus;
import org.monjasa.utopia.domain.event.EventReservation;
import org.monjasa.utopia.domain.invoice.Invoice;
import org.monjasa.utopia.domain.invoice.InvoicePayment;
import org.monjasa.utopia.repository.InvoiceRepository;
import org.monjasa.utopia.service.InvoiceService;
import org.monjasa.utopia.util.builder.InvoiceBuilder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;

    private final InvoiceBuilder invoiceBuilder;

    @Override
    public void createByEventReservation(EventReservation eventReservation, List<AuditoriumSeat> auditoriumSeats) {
        Invoice invoice = invoiceBuilder.buildByEventReservation(eventReservation, auditoriumSeats);
        invoiceRepository.save(invoice);
    }

    @Override
    public void createPaymentByInvoiceNumber(String invoiceNumber, InvoicePayment invoicePayment) {
        Invoice invoice = invoiceRepository.findFetchingPaymentsByNumber(invoiceNumber).orElseThrow();
        if (isInvoicePaymentPresent(invoice, invoicePayment)) {
            return;
        }

        invoice.addInvoicePayment(invoicePayment);
        if (isSettled(invoice)) {
            invoice.setStatus(InvoiceStatus.SETTLED);
            invoice.setSettledAt(invoicePayment.getPaidAt());
        }

        invoiceRepository.save(invoice);
    }

    @Override
    public Invoice getByEventReservationUuid(String eventReservationUuid) {
        return invoiceRepository.findByEventReservationUuid(eventReservationUuid).orElseThrow();
    }

    private boolean isInvoicePaymentPresent(Invoice invoice, InvoicePayment invoicePayment) {
        return invoice.getPayments().stream()
                .anyMatch(payment -> payment.getPaymentId().equals(invoicePayment.getPaymentId()));
    }

    private boolean isSettled(Invoice invoice) {
        BigDecimal paymentsAmount = invoice.getPayments().stream()
                .map(InvoicePayment::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return paymentsAmount.compareTo(invoice.getCharge().getTotal()) == 0;
    }
}
