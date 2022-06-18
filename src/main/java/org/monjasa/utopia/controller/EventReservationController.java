package org.monjasa.utopia.controller;

import lombok.RequiredArgsConstructor;
import org.monjasa.utopia.dto.event.EventReservationDto;
import org.monjasa.utopia.dto.event.EventReservationIdentifierDto;
import org.monjasa.utopia.dto.event.EventReservationRequest;
import org.monjasa.utopia.service.EventReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public/event-reservation")
@RequiredArgsConstructor
public class EventReservationController {

    private final EventReservationService eventReservationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EventReservationIdentifierDto create(@RequestBody EventReservationRequest request) {
        return eventReservationService.create(request);
    }

    @GetMapping("/{uuid}")
    public EventReservationDto getByUuid(@PathVariable String uuid) {
        return eventReservationService.getByUuid(uuid);
    }
}
