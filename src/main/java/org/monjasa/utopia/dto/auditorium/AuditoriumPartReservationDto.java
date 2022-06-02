package org.monjasa.utopia.dto.auditorium;

import lombok.Getter;
import lombok.Setter;
import org.monjasa.utopia.domain.embeddable.AuditoriumPartDimension;

import java.util.List;

@Getter
@Setter
public class AuditoriumPartReservationDto {

    private Long id;

    private String name;

    private Integer displayPosition;

    private AuditoriumPartDimension dimension;

    private List<AuditoriumSeatReservationDto> seats;

}
