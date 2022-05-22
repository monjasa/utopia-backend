package org.monjasa.utopia.domain.auditorium;

import lombok.Getter;
import lombok.Setter;
import org.monjasa.utopia.domain.base.PersistableEntity;
import org.monjasa.utopia.domain.enums.SeatStatus;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class AuditoriumSeat extends PersistableEntity {

    private Integer rowPosition;

    private Integer columnPosition;

    @Enumerated(EnumType.STRING)
    private SeatStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    private AuditoriumPart part;

    @ManyToOne(fetch = FetchType.LAZY)
    private AuditoriumSeatPricingPolicy pricingPolicy;

}
