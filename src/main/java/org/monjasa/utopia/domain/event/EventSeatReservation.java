package org.monjasa.utopia.domain.event;

import lombok.Getter;
import lombok.Setter;
import org.monjasa.utopia.domain.auditorium.AuditoriumSeat;
import org.monjasa.utopia.domain.base.PersistableEntity;
import org.monjasa.utopia.domain.enums.EventSeatReservationStatus;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class EventSeatReservation extends PersistableEntity {

    private String uuid;

    private EventSeatReservationStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    private EventReservation reservation;

    @ManyToOne(fetch = FetchType.LAZY)
    private AuditoriumSeat seat;

}
