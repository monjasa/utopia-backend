package org.monjasa.utopia.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.monjasa.utopia.domain.embeddable.Dimension;

import java.util.List;

@Getter
@Setter
public class AuditoriumPartRequest {

    private String name;

    private Dimension dimension;

    private List<AuditoriumPartRowRequest> rows;

}
