package org.monjasa.utopia.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AuditoriumPartRowRequest {

    private List<AuditoriumPartRowSeatRequest> seats;

}
