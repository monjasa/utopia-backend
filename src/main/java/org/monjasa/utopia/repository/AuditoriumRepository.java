package org.monjasa.utopia.repository;

import org.monjasa.utopia.domain.auditorium.Auditorium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuditoriumRepository extends JpaRepository<Auditorium, Long> {

    @Query("select auditorium from Auditorium auditorium " +
            "join fetch auditorium.seatPricingPolicies auditoriumSeatPricingPolicies " +
            "where auditorium.id = :id")
    Optional<Auditorium> findByIdFetchingSeatPricingPolicies(Long id);

    List<Auditorium> findAllByOrderByName();

}
