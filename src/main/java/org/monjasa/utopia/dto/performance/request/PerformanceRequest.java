package org.monjasa.utopia.dto.performance.request;

import lombok.Getter;
import lombok.Setter;

import java.time.Duration;

@Getter
@Setter
public class PerformanceRequest {

    private String title;

    private String description;

    private Duration duration;

    private PerformanceAttachmentsRequest attachments;

    private Long genreId;

}
