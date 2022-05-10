package org.monjasa.utopia.domain;

import lombok.Getter;
import lombok.Setter;
import org.monjasa.utopia.domain.base.PersistableEntity;
import org.monjasa.utopia.domain.embeddable.Dimension;

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

    @Embedded
    private Dimension dimension;

    @ManyToOne(fetch = FetchType.LAZY)
    private Auditorium auditorium;

    @OneToMany(mappedBy = "part", cascade = {CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = true)
    private List<AuditoriumPartRow> rows = new ArrayList<>();

    public void addAuditoriumPartRow(AuditoriumPartRow row) {
        this.rows.add(row);
        row.setPart(this);
    }
}
