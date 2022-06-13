package org.monjasa.utopia.controller.callback;

import lombok.RequiredArgsConstructor;
import org.monjasa.utopia.service.LiqPayService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/callback/payment")
@RequiredArgsConstructor
public class LiqPayCallbackController {

    private final LiqPayService liqPayService;

    @PostMapping
    public void handleCallback(@RequestParam String data, @RequestParam String signature) {
        liqPayService.handleCallback(data, signature);
    }
}
