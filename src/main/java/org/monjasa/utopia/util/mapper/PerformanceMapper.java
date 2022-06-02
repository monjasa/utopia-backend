package org.monjasa.utopia.util.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.monjasa.utopia.domain.performance.Performance;
import org.monjasa.utopia.dto.performance.PerformanceDto;
import org.monjasa.utopia.dto.performance.PerformanceItemDto;
import org.monjasa.utopia.dto.performance.request.PerformanceRequest;

@Mapper
public interface PerformanceMapper {

    @Mapping(target = "genre.id", source = "genreId")
    Performance toEntity(PerformanceRequest request);

    PerformanceDto toDto(Performance performance);

    PerformanceItemDto toItemDto(Performance performance);

}
