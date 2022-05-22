package org.monjasa.utopia.service.impl;

import lombok.RequiredArgsConstructor;
import org.monjasa.utopia.dto.performance.PerformanceGenreDto;
import org.monjasa.utopia.repository.PerformanceGenreRepository;
import org.monjasa.utopia.service.PerformanceGenreService;
import org.monjasa.utopia.util.mapper.PerformanceGenreMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PerformanceGenreServiceImpl implements PerformanceGenreService {

    private final PerformanceGenreRepository performanceGenreRepository;

    private final PerformanceGenreMapper performanceGenreMapper;

    @Override
    public List<PerformanceGenreDto> getAll() {
        return performanceGenreRepository.findAll().stream()
                .map(performanceGenreMapper::toDto)
                .toList();
    }
}
