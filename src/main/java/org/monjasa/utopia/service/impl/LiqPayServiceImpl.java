package org.monjasa.utopia.service.impl;

import lombok.RequiredArgsConstructor;
import org.monjasa.utopia.dto.liqpay.LiqPayCheckoutDto;
import org.monjasa.utopia.exception.LiqPaySignatureMismatchException;
import org.monjasa.utopia.service.LiqPayService;
import org.monjasa.utopia.util.helper.MessageDigestHelper;
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

    private final LiqPayMapper liqPayMapper;

    private final Encoder encoder = Base64.getEncoder();

    private final Decoder decoder = Base64.getDecoder();

    @Override
    public void handleCallback(String data, String signature) {
        if (!createSignature(data).equals(signature)) {
            throw new LiqPaySignatureMismatchException();
        }

        liqPayMapper.toPaymentResponse(decoder.decode(data));
    }

    @Override
    public LiqPayCheckoutDto getCheckout(String invoiceUuid, String redirectUrl) {
        String data = encoder.encodeToString(liqPayMapper.toCheckoutRequestData(invoiceUuid, redirectUrl));
        String signature = createSignature(data);

        return liqPayMapper.toCheckoutDto(data, signature);
    }

    private String createSignature(String data) {
        byte[] signature = MessageDigestHelper.digestBySha1(this.privateKey + data + this.privateKey);
        return encoder.encodeToString(signature);
    }
}
