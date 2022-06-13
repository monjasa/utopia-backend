package org.monjasa.utopia.service.impl;

import lombok.RequiredArgsConstructor;
import org.monjasa.utopia.domain.invoice.Invoice;
import org.monjasa.utopia.domain.invoice.InvoicePayment;
import org.monjasa.utopia.dto.liqpay.LiqPayPaymentCheckoutDto;
import org.monjasa.utopia.dto.liqpay.response.LiqPayPaymentResponse;
import org.monjasa.utopia.exception.LiqPaySignatureMismatchException;
import org.monjasa.utopia.service.InvoiceService;
import org.monjasa.utopia.service.LiqPayService;
import org.monjasa.utopia.util.helper.MessageDigestHelper;
import org.monjasa.utopia.util.mapper.InvoicePaymentMapper;
import org.monjasa.utopia.util.mapper.LiqPayMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Base64;

import static java.util.Base64.Decoder;
import static java.util.Base64.Encoder;

@Service
@RequiredArgsConstructor
public class LiqPayServiceImpl implements LiqPayService {

    @Value("${app.liqpay.private-key}")
    private String privateKey;

    private final InvoiceService invoiceService;

    private final InvoicePaymentMapper invoicePaymentMapper;

    private final LiqPayMapper liqPayMapper;

    private final Encoder encoder = Base64.getEncoder();

    private final Decoder decoder = Base64.getDecoder();

    @Override
    public void handleCallback(String data, String signature) {
        if (!createSignature(data).equals(signature)) {
            throw new LiqPaySignatureMismatchException();
        }

        LiqPayPaymentResponse paymentResponse = liqPayMapper.toPaymentResponse(decoder.decode(data));
        InvoicePayment invoicePayment = invoicePaymentMapper.toEntity(paymentResponse);

        invoiceService.createPaymentByInvoiceNumber(paymentResponse.getOrderId(), invoicePayment);
    }

    @Override
    public LiqPayPaymentCheckoutDto getCheckout(String eventReservationUuid, String redirectUrl) {
        Invoice invoice = invoiceService.getByEventReservationUuid(eventReservationUuid);
        String data = encoder.encodeToString(liqPayMapper.toCheckoutRequestData(invoice, redirectUrl));
        String signature = createSignature(data);

        return liqPayMapper.toCheckoutDto(data, signature);
    }

    private String createSignature(String data) {
        byte[] signature = MessageDigestHelper.digestBySha1(this.privateKey + data + this.privateKey);
        return encoder.encodeToString(signature);
    }
}
