package org.monjasa.utopia.repository;

import org.monjasa.utopia.domain.performance.PerformanceGenre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerformanceGenreRepository extends JpaRepository<PerformanceGenre, Long> {
}
