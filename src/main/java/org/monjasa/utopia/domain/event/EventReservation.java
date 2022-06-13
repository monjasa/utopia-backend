package org.monjasa.utopia.domain.event;

import lombok.Getter;
import lombok.Setter;
import org.monjasa.utopia.domain.base.SoftDeletableEntity;
import org.monjasa.utopia.domain.embeddable.EventVisitorDetails;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class EventReservation extends SoftDeletableEntity {

    private String uuid;

    @Embedded
    private EventVisitorDetails visitorDetails;

    @ManyToOne(fetch = FetchType.LAZY)
    private Event event;

    @OneToMany(mappedBy = "reservation", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private List<EventSeatReservation> seatReservations = new ArrayList<>();

    public void addEventSeatReservation(EventSeatReservation seatReservation) {
        this.seatReservations.add(seatReservation);
        seatReservation.setReservation(this);
    }
}
