package org.monjasa.utopia.domain;

import lombok.Getter;
import lombok.Setter;
import org.monjasa.utopia.domain.base.PersistableEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class AuditoriumPartRow extends PersistableEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private AuditoriumPart part;

    @OneToMany(mappedBy = "row", cascade = {CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = true)
    private List<AuditoriumPartRowSeat> seats = new ArrayList<>();

    public void addAuditoriumPartRowSeat(AuditoriumPartRowSeat seat) {
        this.seats.add(seat);
        seat.setRow(this);
    }
}
