package org.monjasa.utopia.dto.event;

import lombok.Getter;
import lombok.Setter;
import org.monjasa.utopia.dto.auditorium.AuditoriumReservationDto;
import org.monjasa.utopia.dto.performance.PerformanceDto;

import java.time.LocalDateTime;

@Getter
@Setter
public class EventDto {

    private Long id;

    private LocalDateTime startedAt;

    private LocalDateTime endedAt;

    private PerformanceDto performance;

    private AuditoriumReservationDto auditorium;

}
