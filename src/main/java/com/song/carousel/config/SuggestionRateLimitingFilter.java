package com.song.carousel.config;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Refill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.Duration;

@Component
public class SuggestionRateLimitingFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(SuggestionRateLimitingFilter.class);
    private static final Bucket bucket;

    static {
        Bandwidth limit = Bandwidth.classic(5, Refill.greedy(5, Duration.ofMinutes(1)));
        bucket = Bucket.builder().addLimit(limit).build();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        logger.info("Entering doFilter method");
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        if (httpRequest.getRequestURI().equals("/suggestion")) {
            if (bucket.tryConsume(1)) {
                logger.info("Request allowed. Remaining tokens: {}", bucket.getAvailableTokens());
                chain.doFilter(request, response);
            } else {
                logger.warn("Rate limit exceeded. Blocking request.");
                httpRequest.setAttribute("errorMessage", "Dat zijn te veel suggesties! Probeer het later nog eens.");
                httpRequest.getRequestDispatcher("/suggestion").forward(request, response);
            }
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}