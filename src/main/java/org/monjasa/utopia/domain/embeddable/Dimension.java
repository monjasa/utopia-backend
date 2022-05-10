package org.monjasa.utopia.domain.embeddable;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable
public class Dimension {

    private Integer rows;

    private Integer columns;

}
