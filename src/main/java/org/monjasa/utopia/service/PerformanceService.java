package org.monjasa.utopia.service;

import org.monjasa.utopia.domain.performance.Performance;
import org.monjasa.utopia.dto.performance.PerformanceDto;
import org.monjasa.utopia.dto.performance.PerformanceItemDto;
import org.monjasa.utopia.dto.performance.request.PerformanceRequest;

import java.util.List;

public interface PerformanceService {

    void create(PerformanceRequest request);

    Performance getById(Long id);

    PerformanceDto getDtoById(Long id);

    List<PerformanceItemDto> getAllItems();

}
