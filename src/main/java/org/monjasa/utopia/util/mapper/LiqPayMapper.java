package org.monjasa.utopia.util.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.monjasa.utopia.controller.callback.LiqPayCallbackController;
import org.monjasa.utopia.domain.invoice.Invoice;
import org.monjasa.utopia.dto.payment.LiqPayPaymentCheckoutDto;
import org.monjasa.utopia.dto.payment.request.LiqPayCheckoutRequest;
import org.monjasa.utopia.dto.payment.response.LiqPayPaymentResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@RequiredArgsConstructor
public class LiqPayMapper {

    public static final int LIQPAY_API_VERSION = 3;

    public static final String LIQPAY_PAY_ACTION = "pay";

    @Value("${app.server.base-url}")
    private String baseUrl;

    @Value("${app.liqpay.public-key}")
    private String publicKey;

    private final ObjectMapper objectMapper;

    @SneakyThrows
    public LiqPayPaymentResponse toPaymentResponse(byte[] data) {
        return objectMapper.readValue(data, LiqPayPaymentResponse.class);
    }

    @SneakyThrows
    public byte[] toCheckoutRequestData(Invoice invoice, String redirectUrl) {
        LiqPayCheckoutRequest checkoutRequest = LiqPayCheckoutRequest.builder()
                .version(LIQPAY_API_VERSION)
                .action(LIQPAY_PAY_ACTION)
                .publicKey(publicKey)
                .amount(invoice.getCharge().getTotal())
                .currency(invoice.getCharge().getCurrency())
                .description(invoice.getDescription())
                .orderId(invoice.getNumber())
                .resultUrl(redirectUrl)
                .serverUrl(buildCallbackUrl())
                .build();
        return objectMapper.writeValueAsBytes(checkoutRequest);
    }

    public LiqPayPaymentCheckoutDto toCheckoutDto(String data, String signature) {
        return LiqPayPaymentCheckoutDto.builder()
                .data(data)
                .signature(signature)
                .build();
    }

    private String buildCallbackUrl() {
        return UriComponentsBuilder.fromHttpUrl(baseUrl)
                .path(getCallbackRequestMapping())
                .build()
                .toUriString();
    }

    private String getCallbackRequestMapping() {
        return LiqPayCallbackController.class.getAnnotation(RequestMapping.class).value()[0];
    }
}
