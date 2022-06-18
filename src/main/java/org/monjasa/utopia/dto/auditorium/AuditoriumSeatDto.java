package org.monjasa.utopia.dto.auditorium;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuditoriumSeatDto {

    private Long id;

    private String partName;

    private Integer rowPosition;

    private Integer columnPosition;

}
