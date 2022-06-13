package org.monjasa.utopia.dto.auditorium;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AuditoriumReservationDto {

    private Long id;

    private String name;

    private List<AuditoriumPartReservationDto> parts;

    private List<AuditoriumSeatPricingPolicyDto> seatPricingPolicies;

}
