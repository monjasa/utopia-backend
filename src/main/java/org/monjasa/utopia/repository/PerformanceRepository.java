package org.monjasa.utopia.repository;

import org.monjasa.utopia.domain.performance.Performance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PerformanceRepository extends JpaRepository<Performance, Long> {

    @Query("select performance from Performance performance " +
            "join fetch performance.genre performanceGenre " +
            "where performance.id = :id")
    Optional<Performance> findByIdFetchingGenre(Long id);

    List<Performance> findAllByOrderByTitle();

}
