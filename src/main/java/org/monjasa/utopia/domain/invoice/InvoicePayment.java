package org.monjasa.utopia.domain.invoice;

import lombok.Getter;
import lombok.Setter;
import org.monjasa.utopia.domain.base.AuditableEntity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class InvoicePayment extends AuditableEntity {

    private BigDecimal amount;

    private LocalDateTime paidAt;

    @ManyToOne(fetch = FetchType.LAZY)
    private Invoice invoice;

}
