package org.monjasa.utopia.domain.embeddable;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable
public class InvoicePaymentSenderDetails {

    private String cardBank;

    private String cardMask;

}
