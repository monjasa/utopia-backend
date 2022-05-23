package org.monjasa.utopia.domain.auditorium;

import lombok.Getter;
import lombok.Setter;
import org.monjasa.utopia.domain.base.AuditableEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Auditorium extends AuditableEntity {

    private String name;

    @OneToMany(mappedBy = "auditorium", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private List<AuditoriumPart> parts = new ArrayList<>();

    @OneToMany(mappedBy = "auditorium", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private List<AuditoriumSeatPricingPolicy> seatPricingPolicies = new ArrayList<>();

    public void addAuditoriumPart(AuditoriumPart part) {
        this.parts.add(part);
        part.setAuditorium(this);
    }

    public void addAuditoriumSeatPricingPolicy(AuditoriumSeatPricingPolicy seatPricingPolicy) {
        this.seatPricingPolicies.add(seatPricingPolicy);
        seatPricingPolicy.setAuditorium(this);
    }
}