package org.monjasa.utopia.service.impl;

import lombok.RequiredArgsConstructor;
import org.monjasa.utopia.domain.auditorium.Auditorium;
import org.monjasa.utopia.domain.auditorium.AuditoriumSeatPricingPolicy;
import org.monjasa.utopia.domain.event.EventSeatReservation;
import org.monjasa.utopia.dto.auditorium.AuditoriumItemDto;
import org.monjasa.utopia.dto.auditorium.AuditoriumReservationDto;
import org.monjasa.utopia.dto.auditorium.request.AuditoriumRequest;
import org.monjasa.utopia.repository.AuditoriumRepository;
import org.monjasa.utopia.service.AuditoriumService;
import org.monjasa.utopia.util.mapper.AuditoriumMapper;
import org.monjasa.utopia.util.mapper.AuditoriumSeatPricingPolicyMapper;
import org.springframework.stereotype.Service;

import java.util.List;
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
        Auditorium auditorium = auditoriumMapper.toEntity(request, getSeatPricingPoliciesByDisplayPosition(request));
        auditoriumRepository.save(auditorium);
    }

    @Override
    public List<AuditoriumItemDto> getAllItems() {
        List<Auditorium> auditoriums = auditoriumRepository.findAllByOrderByName();
        return auditoriums.stream()
                .map(auditoriumMapper::toItemDto)
                .toList();
    }

    @Override
    public AuditoriumReservationDto getReservationDtoById(Long id, Map<Long, EventSeatReservation> seatReservationsBySeatId) {
        Auditorium auditorium = auditoriumRepository.findByIdFetchingSeatPricingPolicies(id).orElseThrow();
        return auditoriumMapper.toReservationDto(auditorium, seatReservationsBySeatId);
    }

    private Map<Integer, AuditoriumSeatPricingPolicy> getSeatPricingPoliciesByDisplayPosition(AuditoriumRequest request) {
        return request.getSeatPricingPolicies().stream()
                .map(auditoriumSeatPricingPolicyMapper::toEntity)
                .collect(Collectors.toMap(AuditoriumSeatPricingPolicy::getDisplayPosition, Function.identity()));
    }
}
