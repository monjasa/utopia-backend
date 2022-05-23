package org.monjasa.utopia.util.mapper;

import org.mapstruct.Mapper;
import org.monjasa.utopia.domain.auditorium.AuditoriumSeatPricingPolicy;
import org.monjasa.utopia.dto.auditorium.request.AuditoriumSeatPricingPolicyRequest;

@Mapper
public interface AuditoriumSeatPricingPolicyMapper {

    AuditoriumSeatPricingPolicy toEntity(AuditoriumSeatPricingPolicyRequest request);

}
