package org.monjasa.utopia.domain.permission;

import lombok.Getter;
import lombok.Setter;
import org.monjasa.utopia.domain.base.PersistableEntity;
import org.monjasa.utopia.domain.employee.EmployeePosition;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Authority extends PersistableEntity {

    private String scope;

    private String description;

    @ManyToMany(mappedBy = "authorities")
    private Set<EmployeePosition> positions = new HashSet<>();

}
