package com.song.carousel.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

    private final SuggestionRateLimitingFilter suggestionRateLimitingFilter;
    private final IpBlockingFilter ipBlockingFilter;

    public WebConfig(SuggestionRateLimitingFilter suggestionRateLimitingFilter, IpBlockingFilter ipBlockingFilter) {
        this.suggestionRateLimitingFilter = suggestionRateLimitingFilter;
        this.ipBlockingFilter = ipBlockingFilter;
    }

    @Bean
    public FilterRegistrationBean<IpBlockingFilter> ipBlockingFilterRegistration() {
        FilterRegistrationBean<IpBlockingFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(ipBlockingFilter);
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<SuggestionRateLimitingFilter> suggestionRateLimitingFilterRegistration() {
        FilterRegistrationBean<SuggestionRateLimitingFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(suggestionRateLimitingFilter);
        registrationBean.addUrlPatterns("/suggestion");
        return registrationBean;
    }
}