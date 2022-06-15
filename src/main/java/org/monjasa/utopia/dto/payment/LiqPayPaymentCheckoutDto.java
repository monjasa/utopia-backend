package org.monjasa.utopia.dto.payment;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LiqPayPaymentCheckoutDto {

    private String data;

    private String signature;

}
