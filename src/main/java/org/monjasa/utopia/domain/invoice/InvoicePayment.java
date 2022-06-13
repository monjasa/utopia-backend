package org.monjasa.utopia.domain.invoice;

import lombok.Getter;
import lombok.Setter;
import org.monjasa.utopia.domain.base.AuditableEntity;
import org.monjasa.utopia.domain.embeddable.InvoicePaymentSenderDetails;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Currency;

@Getter
@Setter
@Entity
public class InvoicePayment extends AuditableEntity {

    private Long paymentId;

    private BigDecimal amount;

    private Currency currency;

    private String status;

    private String payType;

    private Instant paidAt;

    @Embedded
    private InvoicePaymentSenderDetails senderDetails;

    @ManyToOne(fetch = FetchType.LAZY)
    private Invoice invoice;

}
