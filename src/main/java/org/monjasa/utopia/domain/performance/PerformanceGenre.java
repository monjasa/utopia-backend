package org.monjasa.utopia.domain.performance;

import lombok.Getter;
import lombok.Setter;
import org.monjasa.utopia.domain.base.PersistableEntity;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class PerformanceGenre extends PersistableEntity {

    private String name;

    private String displayName;

}
