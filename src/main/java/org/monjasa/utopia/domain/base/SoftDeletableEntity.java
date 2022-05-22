package org.monjasa.utopia.domain.base;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public abstract class SoftDeletableEntity extends PersistableEntity {

    private boolean deleted;

}
