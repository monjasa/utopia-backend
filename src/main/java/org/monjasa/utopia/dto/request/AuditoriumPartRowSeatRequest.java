package org.monjasa.utopia.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.monjasa.utopia.domain.enums.SeatStatus;

@Getter
@Setter
public class AuditoriumPartRowSeatRequest {

    private SeatStatus status;

}
