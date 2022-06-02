package org.monjasa.utopia.dto.event;

import lombok.Getter;
import lombok.Setter;
import org.monjasa.utopia.dto.auditorium.AuditoriumItemDto;
import org.monjasa.utopia.dto.performance.PerformanceItemDto;

import java.time.LocalDateTime;

@Getter
@Setter
public class EventConciseDto {

    private Long id;

    private LocalDateTime startedAt;

    private LocalDateTime endedAt;

    private PerformanceItemDto performance;

    private AuditoriumItemDto auditorium;

}
