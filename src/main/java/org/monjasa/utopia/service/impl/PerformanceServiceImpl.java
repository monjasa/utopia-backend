package org.monjasa.utopia.service.impl;

import lombok.RequiredArgsConstructor;
import org.monjasa.utopia.domain.performance.Performance;
import org.monjasa.utopia.dto.performance.PerformanceDto;
import org.monjasa.utopia.dto.performance.PerformanceItemDto;
import org.monjasa.utopia.dto.performance.request.PerformanceRequest;
import org.monjasa.utopia.repository.PerformanceRepository;
import org.monjasa.utopia.service.PerformanceService;
import org.monjasa.utopia.util.mapper.PerformanceMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PerformanceServiceImpl implements PerformanceService {

    private final PerformanceRepository performanceRepository;

    private final PerformanceMapper performanceMapper;

    @Override
    public void create(PerformanceRequest request) {
        Performance performance = performanceMapper.toEntity(request);
        performanceRepository.save(performance);
    }

    @Override
    public Performance getById(Long id) {
        return performanceRepository.findById(id).orElseThrow();
    }

    @Override
    public PerformanceDto getDtoById(Long id) {
        Performance performance = performanceRepository.findByIdFetchingGenre(id).orElseThrow();
        return performanceMapper.toDto(performance);
    }

    @Override
    public List<PerformanceItemDto> getAllItems() {
        List<Performance> performances = performanceRepository.findAllByOrderByTitle();
        return performances.stream()
                .map(performanceMapper::toItemDto)
                .toList();
    }
}
