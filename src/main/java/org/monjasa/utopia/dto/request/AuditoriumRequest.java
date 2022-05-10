package org.monjasa.utopia.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AuditoriumRequest {

    private String name;

    private List<AuditoriumPartRequest> parts;

}
