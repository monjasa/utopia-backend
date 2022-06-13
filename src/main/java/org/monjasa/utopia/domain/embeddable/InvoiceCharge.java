package org.monjasa.utopia.domain.embeddable;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.math.BigDecimal;
import java.util.Currency;

@Getter
@Setter
@Embeddable
public class InvoiceCharge {

    private BigDecimal subtotal;

    private BigDecimal concessionRate;

    private BigDecimal total;

    private Currency currency;

}
