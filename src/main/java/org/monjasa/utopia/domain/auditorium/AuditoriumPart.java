package org.monjasa.utopia.domain.auditorium;

import lombok.Getter;
import lombok.Setter;
import org.monjasa.utopia.domain.base.PersistableEntity;
import org.monjasa.utopia.domain.embeddable.AuditoriumPartDimension;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class AuditoriumPart extends PersistableEntity {

    private String name;

    private Integer displayPosition;

    @Embedded
    private AuditoriumPartDimension dimension;

    @ManyToOne(fetch = FetchType.LAZY)
    private Auditorium auditorium;

    @OneToMany(mappedBy = "part", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private List<AuditoriumSeat> seats = new ArrayList<>();

    public void addAuditoriumSeat(AuditoriumSeat seat) {
        this.seats.add(seat);
        seat.setPart(this);
    }
}
