package org.monjasa.utopia.service;

import org.monjasa.utopia.dto.liqpay.LiqPayPaymentCheckoutDto;

public interface LiqPayService {

    void handleCallback(String data, String signature);

    LiqPayPaymentCheckoutDto getCheckout(String eventReservationUuid, String redirectUrl);

}
