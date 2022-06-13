package org.monjasa.utopia.repository;

import org.monjasa.utopia.domain.auditorium.AuditoriumSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditoriumSeatRepository extends JpaRepository<AuditoriumSeat, Long> {
}
