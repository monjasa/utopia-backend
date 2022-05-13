package org.monjasa.utopia.domain;

import lombok.Getter;
import lombok.Setter;
import org.monjasa.utopia.domain.base.AuditableEntity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class Employee extends AuditableEntity {

    private String uid;

    private String email;

    private String firstName;

    private String lastName;

    @ManyToOne(fetch = FetchType.LAZY)
    private EmployeePosition position;

}
