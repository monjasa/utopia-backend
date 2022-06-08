package org.monjasa.utopia.util.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.monjasa.utopia.controller.callback.LiqPayCallbackController;
import org.monjasa.utopia.dto.liqpay.LiqPayCheckoutDto;
import org.monjasa.utopia.dto.liqpay.request.LiqPayCheckoutRequest;
import org.monjasa.utopia.dto.liqpay.response.LiqPayPaymentResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;

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
    public byte[] toCheckoutRequestData(String invoiceUuid, String redirectUrl) {
        LiqPayCheckoutRequest checkoutRequest = LiqPayCheckoutRequest.builder()
                .version(LIQPAY_API_VERSION)
                .publicKey(publicKey)
                .action(LIQPAY_PAY_ACTION)
                .amount(BigDecimal.valueOf(120)) //from dto
                .currency("UAH") //from dto?
                .description("description") //from dto
                .orderId(invoiceUuid) //from dto
                .resultUrl(redirectUrl)
                .serverUrl(buildCallbackUrl())
                .build();
        return objectMapper.writeValueAsBytes(checkoutRequest);
    }

    public LiqPayCheckoutDto toCheckoutDto(String data, String signature) {
        return LiqPayCheckoutDto.builder()
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
