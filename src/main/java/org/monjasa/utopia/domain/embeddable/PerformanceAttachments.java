package org.monjasa.utopia.domain.embeddable;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable
public class PerformanceAttachments {

    private String posterUrl;

    private String backdropUrl;

}
