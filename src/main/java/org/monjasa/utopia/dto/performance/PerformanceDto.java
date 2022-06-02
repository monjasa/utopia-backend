package org.monjasa.utopia.dto.performance;

import lombok.Getter;
import lombok.Setter;
import org.monjasa.utopia.domain.embeddable.PerformanceAttachments;

import java.time.Duration;

@Getter
@Setter
public class PerformanceDto {

    private Long id;

    private String title;

    private String description;

    private Duration duration;

    private PerformanceAttachments attachments;

    private PerformanceGenreDto genre;

}
