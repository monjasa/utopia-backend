package org.monjasa.utopia.domain.invoice;

import lombok.Getter;
import lombok.Setter;
import org.monjasa.utopia.domain.base.AuditableEntity;
import org.monjasa.utopia.domain.embeddable.InvoiceCharge;
import org.monjasa.utopia.domain.enums.InvoiceStatus;
import org.monjasa.utopia.domain.event.EventReservation;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Invoice extends AuditableEntity {

    private String number;

    private String description;

    private Instant issuedAt;

    private Instant settledAt;

    @Enumerated(EnumType.STRING)
    private InvoiceStatus status;

    @Embedded
    private InvoiceCharge charge;

    @ManyToOne(fetch = FetchType.LAZY)
    private EventReservation eventReservation;

    @OneToMany(mappedBy = "invoice", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private List<InvoicePayment> payments = new ArrayList<>();

    public void addInvoicePayment(InvoicePayment payment) {
        this.payments.add(payment);
        payment.setInvoice(this);
    }
}
