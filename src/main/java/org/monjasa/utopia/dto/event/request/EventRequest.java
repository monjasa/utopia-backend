package org.monjasa.utopia.dto.event.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class EventRequest {

    private LocalDateTime startedAt;

    private Long performanceId;

    private Long auditoriumId;

}
