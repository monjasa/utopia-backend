package org.monjasa.utopia.service;

import org.monjasa.utopia.dto.event.EventConciseDto;
import org.monjasa.utopia.dto.event.EventDto;
import org.monjasa.utopia.dto.event.request.EventRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface EventService {

    void create(EventRequest request);

    EventDto getDtoById(Long id);

    List<EventConciseDto> getAllConcise();

    Slice<EventConciseDto> getAllConcise(Pageable pageable);

}
