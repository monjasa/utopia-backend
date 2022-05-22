package org.monjasa.utopia.domain.event;

import lombok.Getter;
import lombok.Setter;
import org.monjasa.utopia.domain.auditorium.AuditoriumSeat;
import org.monjasa.utopia.domain.base.PersistableEntity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class EventSeatReservation extends PersistableEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private EventReservation reservation;

    @ManyToOne(fetch = FetchType.LAZY)
    private AuditoriumSeat seat;

}
