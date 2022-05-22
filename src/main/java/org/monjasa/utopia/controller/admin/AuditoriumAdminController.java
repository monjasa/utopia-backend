package org.monjasa.utopia.controller.admin;

import lombok.RequiredArgsConstructor;
import org.monjasa.utopia.dto.auditorium.request.AuditoriumRequest;
import org.monjasa.utopia.service.AuditoriumService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/auditorium")
@RequiredArgsConstructor
public class AuditoriumAdminController {

    private final AuditoriumService auditoriumService;

    @PostMapping
    @PreAuthorize("hasAuthority('SCOPE_WRITE_AUDITORIUM')")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody AuditoriumRequest request) {
        auditoriumService.create(request);
    }
}
