package org.monjasa.utopia.controller.admin;

import lombok.RequiredArgsConstructor;
import org.monjasa.utopia.dto.event.EventConciseDto;
import org.monjasa.utopia.dto.event.request.EventRequest;
import org.monjasa.utopia.service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin/event")
@RequiredArgsConstructor
public class EventAdminController {

    private final EventService eventService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('SCOPE_WRITE_EVENT')")
    public void create(@RequestBody EventRequest request) {
        eventService.create(request);
    }

    @GetMapping("/concise/all")
    @PreAuthorize("hasAuthority('SCOPE_READ_EVENT')")
    public List<EventConciseDto> getAllConcise() {
        return eventService.getAllConcise();
    }
}
