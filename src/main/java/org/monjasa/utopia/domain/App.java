package org.monjasa.utopia.domain;

import lombok.Getter;
import lombok.Setter;
import org.monjasa.utopia.domain.base.AuditableEntity;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class App extends AuditableEntity {

    private String value;

}
