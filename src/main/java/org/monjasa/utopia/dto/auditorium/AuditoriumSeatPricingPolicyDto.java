package org.monjasa.utopia.dto.auditorium;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class AuditoriumSeatPricingPolicyDto {

    private Long id;

    private BigDecimal price;

    private Integer displayPosition;

}
