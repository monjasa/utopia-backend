package org.monjasa.utopia.repository;

import org.monjasa.utopia.domain.event.EventReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventReservationRepository extends JpaRepository<EventReservation, Long> {
}
