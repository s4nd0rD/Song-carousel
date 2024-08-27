package com.song.carousel.config;

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
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

@Component
public class IpBlockingFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(IpBlockingFilter.class);
    private static final ConcurrentHashMap<String, Long> ipRequestCounts = new ConcurrentHashMap<>();
    private static final long MAX_REQUESTS = 10;
    private static final long TIME_WINDOW = TimeUnit.MINUTES.toMillis(5);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String ipAddress = httpRequest.getRemoteAddr();
        long currentTime = System.currentTimeMillis();

        ipRequestCounts.merge(ipAddress, currentTime, (oldTime, newTime) -> {
            if (newTime - oldTime > TIME_WINDOW) {
                return newTime;
            } else {
                return oldTime;
            }
        });

        long requestCount = ipRequestCounts.values().stream()
                .filter(time -> currentTime - time <= TIME_WINDOW)
                .count();

        if (requestCount > MAX_REQUESTS) {
            logger.warn("IP address {} blocked due to too many requests", ipAddress);
            httpRequest.setAttribute("errorMessage", "Je hebt teveel suggesties ingeschoten. Probeer het over 5 minuten nog eens.");
            httpRequest.getRequestDispatcher("/suggestion").forward(request, response);
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