package org.monjasa.utopia.domain.invoice;

import lombok.Getter;
import lombok.Setter;
import org.monjasa.utopia.domain.base.AuditableEntity;
import org.monjasa.utopia.domain.embeddable.InvoiceCharge;
import org.monjasa.utopia.domain.enums.InvoiceStatus;
import org.monjasa.utopia.domain.event.EventReservation;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Invoice extends AuditableEntity {

    private String number;

    private String description;

    private LocalDateTime issuedAt;

    private LocalDateTime settledAt;

    @Embedded
    private InvoiceCharge charge;

    @Enumerated(EnumType.STRING)
    private InvoiceStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    private EventReservation eventReservation;

    @OneToMany(mappedBy = "invoice", orphanRemoval = true)
    private List<InvoicePayment> payments = new ArrayList<>();

}
