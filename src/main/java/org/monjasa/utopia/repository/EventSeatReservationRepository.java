package org.monjasa.utopia.repository;

import org.monjasa.utopia.domain.event.EventSeatReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventSeatReservationRepository extends JpaRepository<EventSeatReservation, Long> {

    @Query("select eventSeatReservation from EventSeatReservation eventSeatReservation " +
            "join eventSeatReservation.reservation eventReservation " +
            "join eventReservation.event event " +
            "where eventReservation.deleted = false and event.id = :eventId")
    List<EventSeatReservation> findAllPresentByEventId(Long eventId);

}
