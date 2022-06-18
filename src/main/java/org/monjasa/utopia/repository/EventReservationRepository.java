package org.monjasa.utopia.repository;

import org.monjasa.utopia.domain.event.EventReservation;
import org.monjasa.utopia.repository.base.JpaClearableRepository;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventReservationRepository extends JpaClearableRepository<EventReservation, Long> {

    @EntityGraph(attributePaths = {"event", "seatReservations.seat"})
    Optional<EventReservation> findFetchingEventAndSeatReservationsById(Long id);

    @EntityGraph(attributePaths = {"event", "seatReservations.seat"})
    Optional<EventReservation> findFetchingEventAndSeatReservationsByUuid(String uuid);

}
