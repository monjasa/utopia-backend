package org.monjasa.utopia.controller;

import lombok.RequiredArgsConstructor;
import org.monjasa.utopia.dto.event.EventConciseDto;
import org.monjasa.utopia.dto.event.EventDto;
import org.monjasa.utopia.service.EventService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public/event")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @GetMapping("/{id}")
    public EventDto getById(@PathVariable Long id) {
        return eventService.getDtoById(id);
    }

    @GetMapping("/concise/all")
    public Slice<EventConciseDto> getAllConcise(Pageable pageable) {
        return eventService.getAllConcise(pageable);
    }
}
