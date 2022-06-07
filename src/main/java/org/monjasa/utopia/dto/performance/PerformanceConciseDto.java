package org.monjasa.utopia.dto.performance;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PerformanceConciseDto {

    private Long id;

    private String title;

    private String description;

    private PerformanceGenreDto genre;

}
