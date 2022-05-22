package org.monjasa.utopia.controller.admin;

import lombok.RequiredArgsConstructor;
import org.monjasa.utopia.dto.performance.request.PerformanceRequest;
import org.monjasa.utopia.service.PerformanceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/performance")
@RequiredArgsConstructor
public class PerformanceAdminController {

    private final PerformanceService performanceService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody PerformanceRequest request) {
        performanceService.create(request);
    }
}
