package org.monjasa.utopia.controller.admin;

import lombok.RequiredArgsConstructor;
import org.monjasa.utopia.dto.performance.PerformanceConciseDto;
import org.monjasa.utopia.dto.performance.PerformanceItemDto;
import org.monjasa.utopia.dto.performance.request.PerformanceRequest;
import org.monjasa.utopia.service.PerformanceService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin/performance")
@RequiredArgsConstructor
public class PerformanceAdminController {

    private final PerformanceService performanceService;

    @PostMapping
    @PreAuthorize("hasAuthority('SCOPE_WRITE_PERFORMANCE')")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody PerformanceRequest request) {
        performanceService.create(request);
    }

    @GetMapping("/item/all")
    @PreAuthorize("hasAuthority('SCOPE_READ_PERFORMANCE')")
    public List<PerformanceItemDto> getAllItems() {
        return performanceService.getAllItems();
    }

    @GetMapping("/concise/all")
    @PreAuthorize("hasAuthority('SCOPE_READ_PERFORMANCE')")
    public List<PerformanceConciseDto> getAllConcise() {
        return performanceService.getAllConcise();
    }
}
