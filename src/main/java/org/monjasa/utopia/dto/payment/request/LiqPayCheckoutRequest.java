package org.monjasa.utopia.dto.payment.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Currency;

@Getter
@Setter
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class LiqPayCheckoutRequest {

    private Integer version;

    private String publicKey;

    private String action;

    private BigDecimal amount;

    private Currency currency;

    private String description;

    private String orderId;

    private String resultUrl;

    private String serverUrl;

}
