package org.monjasa.utopia.controller;

import lombok.RequiredArgsConstructor;
import org.monjasa.utopia.dto.performance.PerformanceGenreDto;
import org.monjasa.utopia.service.PerformanceGenreService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/public/performance/genre")
@RequiredArgsConstructor
public class PerformanceGenreController {

    private final PerformanceGenreService performanceGenreService;

    @GetMapping("/all")
    public List<PerformanceGenreDto> getAll() {
        return performanceGenreService.getAll();
    }
}
