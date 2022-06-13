package org.monjasa.utopia.util.provider;

import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class LocaleProvider {

    public Locale getDefaultLocale() {
        return getUkrainianLocale();
    }

    public Locale getUkrainianLocale() {
        return new Locale("uk", "UA");
    }
}
