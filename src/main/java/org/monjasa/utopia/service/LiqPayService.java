package org.monjasa.utopia.service;

import org.monjasa.utopia.dto.liqpay.LiqPayCheckoutDto;

public interface LiqPayService {

    void handleCallback(String data, String signature);

    LiqPayCheckoutDto getCheckout(String invoiceUuid, String redirectUrl);

}
