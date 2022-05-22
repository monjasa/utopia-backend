package org.monjasa.utopia.domain.event;

import lombok.Getter;
import lombok.Setter;
import org.monjasa.utopia.domain.base.AuditableEntity;
import org.monjasa.utopia.domain.embeddable.EventVisitorDetails;
import org.monjasa.utopia.domain.enums.EventReservationStatus;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class EventReservation extends AuditableEntity {

    @Enumerated(EnumType.STRING)
    private EventReservationStatus status;

    @Embedded
    private EventVisitorDetails visitorDetails;

    @ManyToOne(fetch = FetchType.LAZY)
    private Event event;

    @OneToMany(mappedBy = "reservation", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private List<EventSeatReservation> seatReservations = new ArrayList<>();

}
