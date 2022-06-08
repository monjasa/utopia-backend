package org.monjasa.utopia.controller;

import lombok.RequiredArgsConstructor;
import org.monjasa.utopia.dto.liqpay.LiqPayCheckoutDto;
import org.monjasa.utopia.service.LiqPayService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public/liqpay")
@RequiredArgsConstructor
public class LiqPayController {

    private final LiqPayService liqPayService;

    @GetMapping
    public LiqPayCheckoutDto getCheckout(@RequestParam String invoiceUuid, @RequestParam String redirectUrl) {
        return liqPayService.getCheckout(invoiceUuid, redirectUrl);
    }
}
