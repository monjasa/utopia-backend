package org.monjasa.utopia.domain.auditorium;

import lombok.Getter;
import lombok.Setter;
import org.monjasa.utopia.domain.base.PersistableEntity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class AuditoriumSeatPricingPolicy extends PersistableEntity {

    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY)
    private Auditorium auditorium;

}
