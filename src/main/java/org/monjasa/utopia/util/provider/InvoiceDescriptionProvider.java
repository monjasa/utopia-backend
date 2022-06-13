package org.monjasa.utopia.util.provider;

import lombok.RequiredArgsConstructor;
import org.monjasa.utopia.domain.event.Event;
import org.monjasa.utopia.domain.event.EventReservation;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@Component
@RequiredArgsConstructor
public class InvoiceDescriptionProvider {

    private final LocaleProvider localeProvider;

    public String provideDescriptionByEventReservation(EventReservation eventReservation) {
        Event event = eventReservation.getEvent();
        return String.format(
                "Продаж %d квитка(-ів) на виставу %s, час проведення події: %s",
                eventReservation.getSeatReservations().size(),
                event.getPerformance().getTitle(),
                getDateTimeFormatter().format(event.getStartedAt())
        );
    }

    private DateTimeFormatter getDateTimeFormatter() {
        return DateTimeFormatter
                .ofLocalizedDateTime(FormatStyle.MEDIUM)
                .withLocale(localeProvider.getDefaultLocale());
    }
}
