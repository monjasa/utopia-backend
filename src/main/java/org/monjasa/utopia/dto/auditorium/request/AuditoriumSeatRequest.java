package org.monjasa.utopia.dto.auditorium.request;

import lombok.Getter;
import lombok.Setter;
import org.monjasa.utopia.domain.enums.AuditoriumSeatStatus;

@Getter
@Setter
public class AuditoriumSeatRequest {

    private Integer rowPosition;

    private Integer columnPosition;

    private AuditoriumSeatStatus status;

    private Integer pricingPolicyDisplayPosition;

}
