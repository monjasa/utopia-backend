package org.monjasa.utopia.repository;

import org.monjasa.utopia.domain.event.Event;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface EventRepository extends PagingAndSortingRepository<Event, Long> {

    @Query("select event from Event event " +
            "join fetch event.performance performance " +
            "join fetch event.auditorium auditorium " +
            "order by event.startedAt")
    List<Event> findAllFetchingPerformanceAndAuditorium();

    @Query("select event from Event event " +
            "join fetch event.performance performance " +
            "join fetch event.auditorium auditorium " +
            "where event.startedAt > :startedAt " +
            "order by event.startedAt")
    Slice<Event> findAllFetchingPerformanceAndAuditorium(Pageable pageable, Instant startedAt);

}
