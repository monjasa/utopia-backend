package org.monjasa.utopia.dto.auditorium.request;

import lombok.Getter;
import lombok.Setter;
import org.monjasa.utopia.domain.embeddable.AuditoriumPartDimension;

import java.util.List;

@Getter
@Setter
public class AuditoriumPartRequest {

    private String name;

    private Integer displayPosition;

    private AuditoriumPartDimension dimension;

    private List<AuditoriumSeatRequest> seats;

}
