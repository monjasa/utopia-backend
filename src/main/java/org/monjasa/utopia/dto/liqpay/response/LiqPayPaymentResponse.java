package org.monjasa.utopia.dto.liqpay.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;
import org.monjasa.utopia.util.converter.EpochMillisecondsToInstantConverter;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Currency;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class LiqPayPaymentResponse {

    private Long paymentId;

    private String paytype;

    private String status;

    private String orderId;

    private BigDecimal amount;

    private Currency currency;

    private String senderCardBank;

    private String senderCardMask2;

    @JsonDeserialize(converter = EpochMillisecondsToInstantConverter.class)
    private Instant endDate;

}
