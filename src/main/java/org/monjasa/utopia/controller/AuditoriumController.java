package org.monjasa.utopia.controller;

import lombok.RequiredArgsConstructor;
import org.monjasa.utopia.dto.request.AuditoriumRequest;
import org.monjasa.utopia.service.AuditoriumService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/auditorium")
@RequiredArgsConstructor
public class AuditoriumController {

    private final AuditoriumService auditoriumService;

    @PostMapping
    @PreAuthorize("hasAuthority('SCOPE_WRITE_AUDITORIUM')")
    public void create(@RequestBody AuditoriumRequest request) {
        auditoriumService.create(request);
    }
}
