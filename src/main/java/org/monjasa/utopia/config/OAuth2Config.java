package org.monjasa.utopia.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;

@Configuration
public class OAuth2Config {

    public static final String PRINCIPAL_CLAIM_NAME = "email";

    @Bean
    public JwtAuthenticationConverter jwtAuthenticationConverter() {
        JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
        converter.setPrincipalClaimName(PRINCIPAL_CLAIM_NAME);
        return converter;
    }
}
