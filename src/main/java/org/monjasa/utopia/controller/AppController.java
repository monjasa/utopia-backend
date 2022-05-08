package org.monjasa.utopia.controller;

import lombok.RequiredArgsConstructor;
import org.monjasa.utopia.service.AppService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/app")
@RequiredArgsConstructor
public class AppController {

    private final AppService appService;

    @PostMapping(path = "/test")
    @PreAuthorize("hasAuthority('SCOPE_READ')")
    public void test() {
        appService.create();
    }
}
