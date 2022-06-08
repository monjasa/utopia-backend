package org.monjasa.utopia.dto.liqpay;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LiqPayCheckoutDto {

    private String data;

    private String signature;

}
