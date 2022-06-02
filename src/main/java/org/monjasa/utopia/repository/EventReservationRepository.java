package org.monjasa.utopia.repository;

import org.monjasa.utopia.domain.event.EventReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventReservationRepository extends JpaRepository<EventReservation, Long> {

    @Query("select eventReservation from EventReservation eventReservation " +
            "join fetch eventReservation.seatReservations seatReservations")
    List<EventReservation> findAllByEventIdFetchingSeatReservations(Long eventId);

}
