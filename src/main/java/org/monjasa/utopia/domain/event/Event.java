package org.monjasa.utopia.domain.event;

import lombok.Getter;
import lombok.Setter;
import org.monjasa.utopia.domain.performance.Performance;
import org.monjasa.utopia.domain.auditorium.Auditorium;
import org.monjasa.utopia.domain.base.AuditableEntity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Event extends AuditableEntity {

    private LocalDateTime startedAt;

    private LocalDateTime endedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    private Auditorium auditorium;

    @ManyToOne(fetch = FetchType.LAZY)
    private Performance performance;

}
