package org.monjasa.utopia.domain.performance;

import lombok.Getter;
import lombok.Setter;
import org.monjasa.utopia.domain.base.SoftDeletableEntity;
import org.monjasa.utopia.domain.event.Event;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Performance extends SoftDeletableEntity {

    private String title;

    private String description;

    private Duration duration;

    @ManyToOne(fetch = FetchType.LAZY)
    private PerformanceGenre genre;

    @OneToMany(mappedBy = "performance", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private List<Event> events = new ArrayList<>();

}
