package org.monjasa.utopia.controller;

import lombok.RequiredArgsConstructor;
import org.monjasa.utopia.dto.AppDto;
import org.monjasa.utopia.dto.request.AppRequest;
import org.monjasa.utopia.service.AppService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/app")
@RequiredArgsConstructor
public class AppController {

    private final AppService appService;

    @PostMapping
    @PreAuthorize("hasAuthority('SCOPE_READ')")
    public AppDto create(@RequestBody AppRequest request) {
        return appService.create(request);
    }
}
