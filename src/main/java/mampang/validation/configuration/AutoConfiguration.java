package mampang.validation.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import mampang.validation.MampangExceptionHandler;
import mampang.validation.annotation.JsAuthorization.JsAuthorizationAspect;
import mampang.validation.annotation.JsRequestBodyValidation.JsRequestBodyValidationAspect;
import mampang.validation.component.JsResponseGenerator;
import mampang.validation.component.WebClientComponent;

@Configuration
@ComponentScan(basePackages = "mampang.validation")
public class AutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public JsResponseGenerator jsr() {
        return new JsResponseGenerator();
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(name = "js.authorization.enabled", havingValue = "true", matchIfMissing = true)
    public JsAuthorizationAspect jsAuthorizationAspect() {
        return new JsAuthorizationAspect();
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(name = "js.request.body.validation.enabled", havingValue = "true", matchIfMissing = true)
    public JsRequestBodyValidationAspect jsRequestBodyValidationAspect() {
        return new JsRequestBodyValidationAspect();
    }

    @Bean
    @ConditionalOnMissingBean
    public WebClientComponent wc() {
        return new WebClientComponent();
    }

    @Bean
    @ConditionalOnMissingBean
    public MampangExceptionHandler exHandler() {
        return new MampangExceptionHandler();
    }

}
