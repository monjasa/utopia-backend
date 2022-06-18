package org.monjasa.utopia.dto.invoice;

import lombok.Getter;
import lombok.Setter;
import org.monjasa.utopia.domain.embeddable.InvoiceCharge;
import org.monjasa.utopia.domain.enums.InvoiceStatus;

@Getter
@Setter
public class InvoiceStateDto {

    private Long id;

    private String number;

    private InvoiceStatus status;

    private InvoiceCharge charge;

}
