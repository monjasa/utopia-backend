package org.monjasa.utopia.dto.performance;

import lombok.Getter;
import lombok.Setter;
import org.monjasa.utopia.domain.embeddable.PerformanceAttachments;

@Getter
@Setter
public class PerformanceItemDto {

    private Long id;

    private String title;

    private PerformanceAttachments attachments;

}
