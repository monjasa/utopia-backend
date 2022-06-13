package org.monjasa.utopia.dto.auditorium;

import lombok.Getter;
import lombok.Setter;
import org.monjasa.utopia.domain.enums.AuditoriumSeatStatus;

@Getter
@Setter
public class AuditoriumSeatReservationDto {

    private Long id;

    private String partName;

    private Integer rowPosition;

    private Integer columnPosition;

    private AuditoriumSeatStatus status;

    private AuditoriumSeatPricingPolicyDto pricingPolicy;

    private boolean reserved;

}
