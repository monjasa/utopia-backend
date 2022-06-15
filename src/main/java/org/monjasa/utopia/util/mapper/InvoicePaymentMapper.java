package org.monjasa.utopia.util.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.monjasa.utopia.domain.invoice.InvoicePayment;
import org.monjasa.utopia.dto.payment.response.LiqPayPaymentResponse;

@Mapper
public interface InvoicePaymentMapper {

    @Mapping(target = "payType", source = "paytype")
    @Mapping(target = "paidAt", source = "endDate")
    @Mapping(target = "senderDetails.cardBank", source = "senderCardBank")
    @Mapping(target = "senderDetails.cardMask", source = "senderCardMask2")
    InvoicePayment toEntity(LiqPayPaymentResponse response);

}
