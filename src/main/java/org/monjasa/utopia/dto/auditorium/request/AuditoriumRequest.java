package org.monjasa.utopia.dto.auditorium.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AuditoriumRequest {

    private String name;

    private List<AuditoriumSeatPricingPolicyRequest> seatPricingPolicies;

    private List<AuditoriumPartRequest> parts;

}
