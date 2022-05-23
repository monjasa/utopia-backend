package org.monjasa.utopia.service.impl;

import lombok.RequiredArgsConstructor;
import org.monjasa.utopia.domain.auditorium.Auditorium;
import org.monjasa.utopia.domain.auditorium.AuditoriumSeatPricingPolicy;
import org.monjasa.utopia.dto.auditorium.request.AuditoriumRequest;
import org.monjasa.utopia.repository.AuditoriumRepository;
import org.monjasa.utopia.service.AuditoriumService;
import org.monjasa.utopia.util.mapper.AuditoriumMapper;
import org.monjasa.utopia.util.mapper.AuditoriumSeatPricingPolicyMapper;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuditoriumServiceImpl implements AuditoriumService {

    private final AuditoriumRepository auditoriumRepository;

    private final AuditoriumMapper auditoriumMapper;

    private final AuditoriumSeatPricingPolicyMapper auditoriumSeatPricingPolicyMapper;

    @Override
    public void create(AuditoriumRequest request) {
        Auditorium auditorium = auditoriumMapper.toEntity(request, getSeatPricingPolicies(request));
        auditoriumRepository.save(auditorium);
    }

    private Map<Integer, AuditoriumSeatPricingPolicy> getSeatPricingPolicies(AuditoriumRequest request) {
        return request.getSeatPricingPolicies().stream()
                .map(auditoriumSeatPricingPolicyMapper::toEntity)
                .collect(Collectors.toMap(AuditoriumSeatPricingPolicy::getDisplayPosition, Function.identity()));
    }
}
