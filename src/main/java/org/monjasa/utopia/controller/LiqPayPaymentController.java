package org.monjasa.utopia.controller;

import lombok.RequiredArgsConstructor;
import org.monjasa.utopia.dto.liqpay.LiqPayPaymentCheckoutDto;
import org.monjasa.utopia.service.LiqPayService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public/payment")
@RequiredArgsConstructor
public class LiqPayPaymentController {

    private final LiqPayService liqPayService;

    @GetMapping("/checkout")
    public LiqPayPaymentCheckoutDto getCheckout(@RequestParam String eventReservationUuid, @RequestParam String redirectUrl) {
        return liqPayService.getCheckout(eventReservationUuid, redirectUrl);
    }
}
