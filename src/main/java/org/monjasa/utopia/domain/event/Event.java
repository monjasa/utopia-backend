package org.monjasa.utopia.domain.event;

import lombok.Getter;
import lombok.Setter;
import org.monjasa.utopia.domain.auditorium.Auditorium;
import org.monjasa.utopia.domain.base.AuditableEntity;
import org.monjasa.utopia.domain.performance.Performance;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.time.Instant;

@Getter
@Setter
@Entity
public class Event extends AuditableEntity {

    private Instant startedAt;

    private Instant endedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    private Performance performance;

    @ManyToOne(fetch = FetchType.LAZY)
    private Auditorium auditorium;

}
