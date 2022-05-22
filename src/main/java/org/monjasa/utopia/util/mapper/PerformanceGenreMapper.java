package org.monjasa.utopia.util.mapper;

import org.mapstruct.Mapper;
import org.monjasa.utopia.domain.performance.PerformanceGenre;
import org.monjasa.utopia.dto.performance.PerformanceGenreDto;

@Mapper
public interface PerformanceGenreMapper {

    PerformanceGenreDto toDto(PerformanceGenre performanceGenre);

}
