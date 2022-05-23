package org.monjasa.utopia.dto.auditorium.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class AuditoriumSeatPricingPolicyRequest {

    private BigDecimal price;

    private Integer displayPosition;

}
