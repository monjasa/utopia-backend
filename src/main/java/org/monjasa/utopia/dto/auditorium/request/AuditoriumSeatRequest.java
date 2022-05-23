package org.monjasa.utopia.dto.auditorium.request;

import lombok.Getter;
import lombok.Setter;
import org.monjasa.utopia.domain.enums.SeatStatus;

@Getter
@Setter
public class AuditoriumSeatRequest {

    private Integer rowPosition;

    private Integer columnPosition;

    private SeatStatus status;

    private Integer pricingPolicyDisplayPosition;

}
