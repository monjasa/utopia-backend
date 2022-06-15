package org.monjasa.utopia.util.provider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class LocaleProvider {

    @Value("${app.locale.language-tag}")
    private String languageTag;

    public Locale getDefaultLocale() {
        return Locale.forLanguageTag(languageTag);
    }
}
