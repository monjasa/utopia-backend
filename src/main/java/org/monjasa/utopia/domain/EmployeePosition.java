package org.monjasa.utopia.domain;

import lombok.Getter;
import lombok.Setter;
import org.monjasa.utopia.domain.base.PersistableEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class EmployeePosition extends PersistableEntity {

    private String name;

    private String displayName;

    @ManyToMany
    @JoinTable(name = "employee_position_authority",
            joinColumns = @JoinColumn(name = "employee_position_id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id"))
    private Set<Authority> authorities = new HashSet<>();

}
